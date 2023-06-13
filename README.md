# CMPE 172 Starbucks-Cashier Project 

[Daily Journals](https://github.com/nguyensjsu/cmpe172-jj904/blob/main/project/README.md)
==================================

[Project Demo](https://www.youtube.com/watch?v=ywEJ_E0ujvc)

<h2>1. About The Starbucks Project</h2>
<img width="400" alt="Logo" src="https://github.com/jj904/Spring-MVC-App/assets/57935131/f8184b33-460f-4f64-bc79-91828eb129a4">
<br>
This is a comprehensive project by applying the labs learned in CMPE172. The Starbucks project consists of a multi-component, multi-layered, end-to-end system.<br><br>
The system of the Starbucks app is as follows.<br>
- Cashier' App:  Cashiers helps place the customer's order <br>
- Starbuck App:  Mobile app to pay for customer orders <br>
- Starbucks API: Process requests from both the Cashier's and Starbucks apps <br>


<h2>2. Cashier's App</h2>
- Spring-cashier
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

<img width="973" alt="Screenshot 2023-06-12 at 6 50 56 PM" src="https://github.com/jj904/Spring-MVC-App/assets/57935131/3baff368-ea04-4285-b359-6b3e9bf1c1ba">
<img width="461" alt="p2" src="https://github.com/jj904/Spring-MVC-App/assets/57935131/57c38790-c9af-4d4e-abf9-0127ac192c4f">

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
<img width="1073" alt="p4" src="https://github.com/jj904/Spring-MVC-App/assets/57935131/7ffd7896-e046-4520-95da-0faff6982190">


### MySQL on GKE
<img width="1141" alt="Q3" src="https://github.com/jj904/Spring-MVC-App/assets/57935131/fb9438e6-9d40-43d7-acdd-1914dd0e234a">
<img width="1141" alt="Q5" src="https://github.com/jj904/Spring-MVC-App/assets/57935131/5f709fc7-8a97-4c6c-8342-9971a4d3a348">


<br><br>
<h2>6. Project Result </h2>

### In My GKE Cluster
* Workloads showing healthy
<img width="1142" alt="WD1" src="https://github.com/jj904/Spring-MVC-App/assets/57935131/8c5f91a8-8847-4881-9f34-6e9e52043e42">


* Services and Ingress(with Public LB IP address) showing healthy
<img width="1139" alt="S1" src="https://github.com/jj904/Spring-MVC-App/assets/57935131/53910a72-0c26-4cdb-acda-f4f60070b16b">
<img width="1142" alt="S2" src="https://github.com/jj904/Spring-MVC-App/assets/57935131/8f2f59cf-16e3-4880-b38e-4c5b6eac6be7">



### In the spring-cashier Deployment Pods showing healthy
<img width="1142" alt="WD1" src="https://github.com/jj904/Spring-MVC-App/assets/57935131/b30433f8-84b3-4701-a738-c6ce0e8ec51a">
<br><br>

### RabbitMQ with Load Balacner with Public LB IP address
<img width="1141" alt="R1" src="https://github.com/jj904/Spring-MVC-App/assets/57935131/42ccaff1-3103-4e99-9691-8a734d0248e8">
<img width="1136" alt="R2" src="https://github.com/jj904/Spring-MVC-App/assets/57935131/f7699b0a-f3b2-4689-92e3-a7fcb6775148">


<br><br>

### Connect to Backend MySQL Database and show all tables in your MySQL DB
<img width="1136" alt="Q1" src="https://github.com/jj904/Spring-MVC-App/assets/57935131/2a0575a3-cbdb-4fc9-a5da-b3894c04321c">
<br><br>

### spring-cashier Login Page with Load Balacner 
<img width="1139" alt="LD" src="https://github.com/jj904/Spring-MVC-App/assets/57935131/6295dd19-ada3-4907-add0-f926f335d686">
<img width="1142" alt="D0" src="https://github.com/jj904/Spring-MVC-App/assets/57935131/08b5d85a-fee9-43b1-b1d4-f93afd33b3ab">
<img width="1135" alt="D1" src="https://github.com/jj904/Spring-MVC-App/assets/57935131/773a91c3-4f74-419a-b560-44ae148f131d">

<br><br>

### user info saved in DB
<img width="1140" alt="D2" src="https://github.com/jj904/Spring-MVC-App/assets/57935131/896ac973-d0a0-45e1-b38a-00cd6b4b2ce4">
<br><br>
<img width="1145" alt="Q2" src="https://github.com/jj904/Spring-MVC-App/assets/57935131/d4f4fd98-ded0-41a4-9d1e-888a5bd90519">
<br><br>

### spring-cashier Starbucks with Load Balacner
* Place Order and 1st Generate Random Order
<img width="1140" alt="RO1" src="https://github.com/jj904/Spring-MVC-App/assets/57935131/d617bb98-fc24-47ba-a6eb-619f27fe71da">
<img width="1143" alt="RO2" src="https://github.com/jj904/Spring-MVC-App/assets/57935131/ac89d45e-bd9a-484f-9872-e0827a7a173f">

<br><br>

* Place Order with 2nd store and Generate Random Order
<img width="1140" alt="RO3" src="https://github.com/jj904/Spring-MVC-App/assets/57935131/951519e4-8472-4440-824d-389e4c2e070d">
<img width="1142" alt="RO4" src="https://github.com/jj904/Spring-MVC-App/assets/57935131/7fe29118-7813-48e1-9e59-dc2c82fb7dba">
<br><br>

### Log from spring-cashier deloyment
<img width="1142" alt="log_deploy" src="https://github.com/jj904/Spring-MVC-App/assets/57935131/401c8a1c-8185-43f8-aba3-b7a31d514e83">



