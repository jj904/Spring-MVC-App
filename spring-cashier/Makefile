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
	java -jar target/spring-cashier-1.0.jar

# cashier Network

network-create:
	docker network create --driver bridge cashier

network-inspect:
	docker network inspect cashier

network-ls:
	docker network ls

network-prune:
	docker network prune


# RabbitMQ

rabbit-shell:
	docker exec -it rabbitmq bash 

rabbit:
	docker run --name rabbitmq \
	           --network cashier \
			   -p 9090:15672 -p 4369:4369 -p 5672:5672 \
			   -d rabbitmq:3-management

rabbit-console:
	open http://localhost:9090

# Management Console: http://localhost:9090
# username and password of guest / guest:


# MySQL DB

mysql:
	docker run --platform=linux/amd64 -d --network cashier --name mysql -td -p 3306:3306 -e MYSQL_ROOT_PASSWORD=cmpe172 mysql:8.0

mysql-shell:
	docker exec -it mysql bash


# Docker

docker-build: build
	docker build --platform=linux/amd64 -t spring-cashier .
	docker images

docker-run: docker-build
	docker run --platform=linux/amd64 --name spring-cashier -td -p 80:8080 spring-cashier	
	docker ps

docker-clean:
	docker stop spring-cashier
	docker rm spring-cashier
	docker rmi spring-cashier

docker-shell:
	docker exec -it spring-cashier bash 

docker-push:
	docker login
	docker build --platform=linux/amd64 -t $(account)/spring-cashier .
	docker push $(account)/spring-cashier


# Compose

network-ls:
	docker network ls 

network-create:
	docker network create --driver bridge $(network)

network-prune:
	docker network prune

compose-up:
	docker-compose up --scale starbucks-cashier=2 -d

lb-up:
	docker-compose up -d lb

starbucks-up:
	docker-compose up -d starbucks

mysql-up:
	docker-compose up -d mysql

compose-down:
	docker-compose down 	

lb-stats:
	echo "user = admin | password = admin"
	open http://localhost:1936

lb-test:
	open http://localhost

# Pod

pod-run:
	kubectl apply -f pod.yaml

pod-list:
	kubectl get pods

pod-desc:
	kubectl describe pods spring-cashier

pod-delete:
	kubectl delete -f pod.yaml

pod-shell:
	kubectl exec -it spring-cashier -- /bin/bash

pod-logs:
	kubectl logs -f spring-cashier

# Deployment

deployment-create:
	kubectl create -f deployment.yaml --save-config 

deployment-get:
	kubectl get deployments

deployment-get-pods:
	kubectl get pods -l name=spring-cashier

deployment-pod-shell:
	kubectl exec -it $(pod) -- /bin/bash

deployment-upgrade:
	kubectl apply  -f deployment.yaml

deployment-delete:
	kubectl delete deployment spring-cashier-deployment

# Service

service-create:
	kubectl create -f service.yaml

service-get:
	kubectl get services

service-get-ip:
	kubectl get service spring-cashier -o wide

service-delete:
	kubectl delete service spring-cashier

# Ingress

ingress-apply:
	kubectl apply -f ingress.yaml

ingress-ip:
	kubectl get ingress spring-cashier-ingress

