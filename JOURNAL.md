# CMPE 172 Starbucks-Cashier Project 

[Daily Journals](https://github.com/nguyensjsu/cmpe172-jj904/blob/main/project/README.md)
==================================

[Project Demo](https://www.youtube.com/watch?v=ywEJ_E0ujvc)

<h2>1. About The Starbucks Project</h2>
![Screenshot 2023-05-21 at 4 33 30 PM](https://github.com/jj904/Spring-MVC-App/assets/57935131/cdb22542-1f14-4c7b-96df-383d5f59b2b8)
This is a comprehensive project by applying the labs learned in CMPE172. The Starbucks project consists of a multi-component, multi-layered, end-to-end system.<br><br>
The system of the Starbucks app is as follows.
* Cashier' App- Cashiers helps place the customer's order. 
* Starbuck App- Mobile app to pay for customer orders 
* Starbucks API- Process requests from both the Cashier's and Starbucks apps.


<h2>2. Cashier's App</h2>
* Spring-cashier
To complete the partial demo, the only file used is spring-cashier. The code I added can be found in the /project/spring-cashier app in my GitHub repository. I've completed pages with this each function..

1) Login page
- User registration function: New users must sign up to access the application.
- Dashboard: After successful login, a page showing the role of the member and their email address 
(user can go to the homepage or log out) 


2) Homepage- Starbucks app
- Users who are logged in can access the Starbucks app.
- When the user presses the get order button, the register number appears and a status message appears.
- When the user selects Store and presses place order, a random list of drinks is ordered. 
(Drink type, size, and milk type are randomly generated as the store changes.)

<h2>3. Architecture</h2>

### Architecture that I used ..
<img width="461" alt="Screenshot 2023-05-22 at 10 26 15 PM" src="https://github.com/jj904/Spring-MVC-App/assets/57935131/597defa4-0581-48e2-8c6d-e5d6f8121b0b">
<br><br>

### In this Project I used.. 
- JAVA
- SPRING
- MYSQL
- DOCKER
- BOOT STRAP
- GOOGLE CLOUD
- RABBITMQ
- HTML/CSS/JS

<h2>4. Getting Started</h2>

* For building Multi-architecture docker images, I used "Buildx". Multi-architecture docker images allow to build and deploy docker images that can run on multiple processor architectures, such as x86 or ARM. Since my environment is Mac M1, I used Docker images through multiple architectures. Here's an overview of how I used buildx to create multi-architecture Docker images.

### Running the program
```
all: clean

clean:
	mvn clean

compile:
	mvn compile

run: compile
	mvn spring-boot:run

build:
	mvn package

run-jar: build
	java -jar target/spring-gumball-1.0.jar
```
	
### Build multi-architecture docker images with Buildx 
```	
docker buildx ls

#Remove : docker buildx rm (name)

docker login

docker buildx create --name spring-cashier

docker buildx use spring-cashier

docker buildx inspect --bootstrap
	
docker buildx build \ --platform linux/amd64,linux/arm64,linux/arm/v7 \ -t jj904/spring-cashier:latest \ --push \ .  

# if error come out as ERROR: "docker buildx build" requires exactly 1 argument: 
docker buildx build  -f Dockerfile -t spring-cashier .

	
#push to docker hub:

docker-push account=jj904:
	docker login
	docker build --platform=linux/amd64 -t $(account)/spring-gumball:v1.0 .
	docker push $(account)/spring-gumball:v1.0 
```	
<br>

### Deploy Gumball to GKE

* For Example:
```
kubectl create -f deployment.yaml --save-config 
kubectl create -f service.yaml
kubectl apply -f ingress.yaml
```
### Jumpbox

* Alternatively, Install MySQL into a GCE (Google Compute Engine VM)

* https://cloud.google.com/solutions/setup-mysql
* https://cloud.google.com/solutions/mysql-remote-access

* Name:           mysql
* Machine Type:   e2-micro
* OS:             Ubuntu
* OS version:     18.04 LTS
<br>

* Install Curl & Ping in my "Jump Box"
```
apt-get update
apt-get install curl
apt-get install iputils-ping
apt-get install telnet
apt-get install httpie
```
* Set up MySQL in GKE
```
kubectl exec -it jumpbox -- /bin/bash	
apt-get update	
apt-get install mysql-client 
mysql -u admin -p -h 10.28.0.3 cmpe172

#PASSWORD = cmpe172
#inside sql>
mysql> use cmpe172 ;
mysql> show tables ;
mysql> select * from users ; 
```
* After create service.yaml and install curl in my "Jump Box"	
```
apt-get install curl
curl http://spring-cashier-service:8080
```

<h2>5. Compelete Set Up </h2>

### Docker Hub
* Successed to push docker images to the docker hub
<img width="986" alt="Screenshot 2023-05-22 at 9 19 13 PM" src="https://github.com/nguyensjsu/cmpe172-jj904/assets/57935131/f45eabf5-5dbc-4ff4-bbac-9fc60e18d8dd">
<img width="1073" alt="Screenshot 2023-05-22 at 9 19 27 PM" src="https://github.com/nguyensjsu/cmpe172-jj904/assets/57935131/d09ca20e-d594-4a66-a2cc-e3e02dfbf95c">

### MySQL on GKE
<img width="1141" alt="Screenshot 2023-05-22 at 9 25 04 PM" src="https://github.com/nguyensjsu/cmpe172-jj904/assets/57935131/29bd8aa9-4502-4e5c-abb7-51dce540e97a">
<img width="1141" alt="Screenshot 2023-05-22 at 9 25 16 PM" src="https://github.com/nguyensjsu/cmpe172-jj904/assets/57935131/006654a2-31e6-49eb-9ef6-abd7d6568ac9">


<br><br>
<h2>6. Project Result </h2>

### In My GKE Cluster
* Workloads showing healthy
<img width="1139" alt="Screenshot 2023-05-22 at 9 26 21 PM" src="https://github.com/nguyensjsu/cmpe172-jj904/assets/57935131/45e919b4-69af-48af-9c9b-08a98e2b80a5">
<br><br>

* Services and Ingress(with Public LB IP address) showing healthy
<img width="1139" alt="Screenshot 2023-05-22 at 9 26 30 PM" src="https://github.com/nguyensjsu/cmpe172-jj904/assets/57935131/c64b0e76-a701-4592-86cd-2ba7a810325c">
<img width="1142" alt="Screenshot 2023-05-22 at 9 26 38 PM" src="https://github.com/nguyensjsu/cmpe172-jj904/assets/57935131/bda768d5-b103-4c94-98f6-612a6d83ba8d">
<br><br>


### In the spring-cashier Deployment Pods showing healthy
<img width="1142" alt="Screenshot 2023-05-22 at 9 27 06 PM" src="https://github.com/nguyensjsu/cmpe172-jj904/assets/57935131/7aa26c35-81a1-4e1a-85c2-d87e673a59b9">
<br><br>

### RabbitMQ with Load Balacner with Public LB IP address
<img width="1141" alt="Screenshot 2023-05-22 at 9 27 23 PM" src="https://github.com/nguyensjsu/cmpe172-jj904/assets/57935131/24347385-26e1-44cd-82f6-e8a37de4a2d8">
<img width="1136" alt="Screenshot 2023-05-22 at 9 27 37 PM" src="https://github.com/nguyensjsu/cmpe172-jj904/assets/57935131/5a716ed6-ea3e-4dcf-bfb9-67ff7359d9eb">

<br><br>

### Connect to Backend MySQL Database and show all tables in your MySQL DB
<img width="1136" alt="Screenshot 2023-05-22 at 9 34 26 PM" src="https://github.com/nguyensjsu/cmpe172-jj904/assets/57935131/47c98cb2-a07f-4e84-b188-78688d20f052">
<br><br>

### spring-cashier Login Page with Load Balacner 
<img width="1139" alt="Screenshot 2023-05-22 at 9 28 18 PM" src="https://github.com/nguyensjsu/cmpe172-jj904/assets/57935131/eae6b91a-0169-4c03-b6c1-e37cc157157a">
<img width="1142" alt="Screenshot 2023-05-22 at 9 29 14 PM" src="https://github.com/nguyensjsu/cmpe172-jj904/assets/57935131/183b6dba-72bc-405b-93ec-ac5f05620f3b">
<img width="1135" alt="Screenshot 2023-05-22 at 9 29 45 PM" src="https://github.com/nguyensjsu/cmpe172-jj904/assets/57935131/c61e7384-2d46-4a46-960f-dd353fa77ba3">
<br><br>

### user info saved in DB
<img width="1145" alt="Screenshot 2023-05-22 at 9 34 42 PM" src="https://github.com/nguyensjsu/cmpe172-jj904/assets/57935131/d73ed0cc-26ff-4661-9dd8-ef415286e0c4">
<br><br>
<img width="1140" alt="Screenshot 2023-05-22 at 9 34 56 PM" src="https://github.com/nguyensjsu/cmpe172-jj904/assets/57935131/65821f5a-62c1-4cae-bac1-e70589c8bfd2">

<br><br>

### spring-cashier Starbucks with Load Balacner
* Place Order and Generate Random Order
<img width="1140" alt="Screenshot 2023-05-22 at 9 30 30 PM" src="https://github.com/nguyensjsu/cmpe172-jj904/assets/57935131/0d26068c-bfbb-4c89-a036-7d30a38fcf1e">
<img width="1143" alt="Screenshot 2023-05-22 at 9 30 39 PM" src="https://github.com/nguyensjsu/cmpe172-jj904/assets/57935131/422e25d9-5000-4340-b856-5138546003ae">
<br><br>

* Place Order with other store ans Generate Random Order
<img width="1140" alt="Screenshot 2023-05-22 at 9 30 48 PM" src="https://github.com/nguyensjsu/cmpe172-jj904/assets/57935131/e11eb1b8-63ac-42be-be76-1afacb3f7a22">
<img width="1142" alt="Screenshot 2023-05-22 at 9 30 57 PM" src="https://github.com/nguyensjsu/cmpe172-jj904/assets/57935131/a7ca16d6-4c21-4a44-8e09-b9aa8a419644">
<br><br>

### Log from spring-cashier deloyment
<img width="1142" alt="Screenshot 2023-05-22 at 9 32 33 PM" src="https://github.com/nguyensjsu/cmpe172-jj904/assets/57935131/56b3f6c3-79fd-40de-9589-dbe465dc7120">




