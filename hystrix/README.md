## 断路器（Hystrix）

---


### 启动注册中心 eureka-server



### 启动一个服务提供实例 provider-service


### 启动一个消费实例 consumer-service


application.properties

```
spring.application.name=consumer-service

server.port=8021
eureka.client.serviceUrl.defaultZone=http://localhost:1111/eureka/


eureka.instance.lease-renewal-interval-in-seconds=5
eureka.instance.lease-expiration-duration-in-seconds=5

```


http://localhost:8021/hello?name=Tom

```
返回结果：

hello，Tom,host:192.168.0.3,service_id:provider-service,port:8010
```

然后，将provider-service服务停掉


http://localhost:8021/hello?name=Tom

```
返回结果：

触发了熔断机制
```










