# microservices-demo-implementation
Application	Port
## Ports

|     Application       |     Port          |
| ------------- | ------------- |
| MuskySystem | 6060,6061 ... |
| Config Server | 8888 |
|  |  |
| Billing management Service | 5050, 5051, ..  |
| customer management Service | 9090, 9091,... |
| discovery Server | 8761 |
| Netflix Zuul API Gateway Server | 8765 |
| Zipkin Distributed Tracing Server | 9411 |

## Ranga Local Instructions
## URLs
```
http://localhost:<gateway_port>/application_name/url

http://localhost:8765/customer-management-system/customer-api/customer/ (POST)
```
```
install rabbitmq
/usr/local/sbin/rabbitmq-server
curl -X POST localhost:8080/actuator/refresh
curl -X POST localhost:8080/actuator/bus-refresh
```

## Run app sequence 
```
java -jar <appname.jar>
sequence :
#1 API-discovery-server
#2 api-zull-gateway
#3 zipkin
#4 ConfigServer
#5 BillingManagemenetService
#6 CustomerManagementSystem
#7 MuskySystem
```