== Executing the application on Docker:

== First Run Only:
docker pull rabbitmq:latest
docker run -d --name rabbit-mq -p 5671-5672:5671-5672 --restart unless-stopped rabbitmq:latest

mysql -uroot -p123456 -h 127.0.0.1
mysql> create database modelTrainingDB;

== Everytime the application is modified:

mvn clean install

docker build . -t mtservice -f dockerFile

docker run -p 8080:8080 -p 38787:38787 --name mtservice --link payrollresultsdb:mysql --link authservice:authservice --link rabbit-mq:rabbit-mq --restart unless-stopped -d mtservice

== Stopping and Removing containers:

docker stop mtservice
docker rm mtservice

== Logging
docker logs -f mtservice

== Container EXEC

docker exec -it mtservice sh
