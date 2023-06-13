# CMPE 172 Project Journal
<h2>Project Journal</h2>

[Starbucks Project Overall Journals](https://github.com/nguyensjsu/cmpe172-jj904/blob/main/project/JOURNAL.md) 
==================================
<br>
<h3>Journal:1_5/5<h3>
Today, I made a commit by modifying the cashier's app a little more. I checked that there is still an error in the login part, and I need to correct this part more. I'm working on it to fix it. This week, we will complete the login and New Account Registration then commit.
  
<br><br>
<h3>Journal: 2_5/7<h3>
Today, I upload Kong PAI
I've worked on casher's app to implement the features needed for orders created via REST API calls to Kong Endpoint, and I haven't succeeded yet, but today I uploaded the Kong API folder, and I think I'll have to spend a little more time implementing this for the rest of my time.
  
<br><br>
<h3>Journal: 3_5/9<h3>
Today, I've been tried to ping api(localhost:8080/ping) from the spring casher's docker container, but the connection was rejected due to an I/O error. I've come up with a way to solve this problem, and I'm still trying to solve it. Now I have conducted a test with the postman, and the endpoint returns a ping for me.

<br><br>
<h3>Journal: 4_5/11<h3>  
Today, we had time to understand GKE architecture. GKE architecture.Kubeentes can use its own infrastructure (e.g., built-in) to manage the number of container (internal load balancers) running at a time, and external load balancers are services running internally that use third-party programs to distribute the load on services. Understanding the structure helps you understand the project.

<br><br>
<h3>Journal: 5_5/12<h3>   
 I found out that my casher's app is not working.  So I checked the port that exposes the docker file and compared it to the port that I want to run in gke. There is still a problem and I plan to solve it by tomorrow.
 
  
 <br><br>
<h3>Journal: 6_5/18<h3>   
I modified the Cashier'app to do a partial demo. I added login and membership, and I checked that there was no error. So I was able to finish this part, and now when I place an order, I'm doing the part where I change it to a random order, but there's an error, so I'm going to fix it tomorrow.
  
 <br><br>
<h3>Journal: 7_5/19<h3> 
 Today, I fixed the error from the random order part from Casher's app and confirmed that the random order is doing well. I'm currently trying to connect to Google Cloud Kubernetes, but I'm still getting a bunch of errors and trying to fix this. Also, I uploaded the updated casher's app and added the Kubernetes file to it and added the files needed for GKE.

<br><br>
<h3>Journal: 8_5/20<h3> 
  I spent time distributing to GKE again today, but I still get errors. Especially after pushing on docker hub, there was a continuous issue in the process of distributing on GKE. Since I use Mac M1, I use arm64 architecture when I use docker build. Since I kept finding issues with nodes in this project, I tried to use multi-architecture by using docker buildx, but since it still works well in my environment, I think I'll spend more time fixing this issue.
<img width="1512" alt="Screenshot 2023-05-21 at 6 16 55 AM" src="https://github.com/nguyensjsu/cmpe172-jj904/assets/57935131/bc3e3f2c-2947-4190-924d-c0eb677c5008">

  
 <br><br>
<h3>Journal: 9_5/21<h3> 
 Since yesterday, deploying service.ymal and ingree.yaml including deployment.yaml to GKE keeps failing, so I worked on this part until today, and I succeeded in deploying it. The program is also connected well, and when I open the app on lb, login and register for users work smoothly. Also, it was confirmed that the user's information save well on mysql.
<img width="1224" alt="Screenshot 2023-05-21 at 4 32 20 PM" src="https://github.com/nguyensjsu/cmpe172-jj904/assets/57935131/7ccc0d94-a881-402d-ab80-eda9b7eef0e0">
<img width="1219" alt="Screenshot 2023-05-21 at 4 32 29 PM" src="https://github.com/nguyensjsu/cmpe172-jj904/assets/57935131/6e10c437-030a-4cab-822e-666e7b7d2df8">
<img width="1218" alt="Screenshot 2023-05-21 at 4 32 40 PM" src="https://github.com/nguyensjsu/cmpe172-jj904/assets/57935131/6c07b1b6-fb36-4b26-979e-3e9172e8e2dc">
<br><br>
 - when open the lb port:
<img width="1221" alt="Screenshot 2023-05-21 at 4 32 54 PM" src="https://github.com/nguyensjsu/cmpe172-jj904/assets/57935131/7a01d849-301d-4e4a-a28c-30b549842b75">
<img width="1221" alt="Screenshot 2023-05-21 at 4 33 56 PM" src="https://github.com/nguyensjsu/cmpe172-jj904/assets/57935131/932378b1-64ff-46f0-b203-31595b3889bc">
<img width="1217" alt="Screenshot 2023-05-21 at 4 33 30 PM" src="https://github.com/nguyensjsu/cmpe172-jj904/assets/57935131/62375158-7e71-443c-8cb9-6f920f45064c">

  
 <br><br>
<h3>Journal: 10_5/21<h3> 
 Today is the last day of the project, and we distributed the RabbitMQ after solved issue to GKE, which had a problem with the deployment yesterday. By recreating the spring-cashier-1.0.jar file, it was possible to distribute the RabbitMQ without any problems. Of course, it doesn't connect well in the part where I get the message, but today I finished the project, wrote a project journal, and also created a demo through the part that works well. Workloads and Services & Ingrees deployed in GKE work well, and accessing Starbucks apps through a load balancer works well.
 
### RabbitMQ successfully depoly on GKE
<img width="1512" alt="Screenshot 2023-05-22 at 3 21 16 AM" src="https://github.com/nguyensjsu/cmpe172-jj904/assets/57935131/642f656c-3d2e-447a-9fe6-8533f5fb1089">
<img width="728" alt="Screenshot 2023-05-22 at 3 21 32 AM" src="https://github.com/nguyensjsu/cmpe172-jj904/assets/57935131/3eed2c16-6fa9-4428-9c4f-8d43405da2bc">
<img width="871" alt="Screenshot 2023-05-22 at 3 21 37 AM" src="https://github.com/nguyensjsu/cmpe172-jj904/assets/57935131/35289a98-c6b9-4eab-9820-3a520a357d19">
  
### RabbitMQ running with Load Balancer in GKE  
<img width="1512" alt="Screenshot 2023-05-22 at 3 21 45 AM" src="https://github.com/nguyensjsu/cmpe172-jj904/assets/57935131/3a0ada1a-2805-49f0-8e98-22e5fe30b931">
<img width="1512" alt="Screenshot 2023-05-22 at 3 21 52 AM" src="https://github.com/nguyensjsu/cmpe172-jj904/assets/57935131/88b4e449-8786-47f7-91b6-f3ffb9e03c5d">


