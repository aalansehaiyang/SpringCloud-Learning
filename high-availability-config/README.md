# 高可用分布式配置中心

---

### 启动eureka-server

配置文件 application.properties

```
spring.application.name=eureka-server
server.port=1111
eureka.instance.hostname=r1
eureka.client.register-with-eureka=true


eureka.client.serviceUrl.defaultZone=http://${eureka.instance.hostname}:${server.port}/eureka/

eureka.instance.lease-renewal-interval-in-seconds=5
eureka.instance.lease-expiration-duration-in-seconds=5
```

### 启动config-server


配置文件 application-1.properties

```
server.port=8003
spring.application.name=config-server
# 配置git仓库地址
spring.cloud.config.server.git.uri=https://github.com/aalansehaiyang/SpringCloudConfig.git
# 配置仓库路径
spring.cloud.config.server.git.search-paths=/config-repo
# 配置仓库的分支
spring.cloud.config.label=master
eureka.client.serviceUrl.defaultZone=http://localhost:1111/eureka/
```

启动三个实例：

```
java -jar config-server-1.0.0.jar --spring.profiles.active=1  >/dev/null &
java -jar config-server-1.0.0.jar --spring.profiles.active=2  >/dev/null &
java -jar config-server-1.0.0.jar --spring.profiles.active=3  >/dev/null &

```


### 启动config-client-1


配置文件bootstrap.properties

```
\# 和git里的文件名对应
spring.application.name=config-client-1
server.port=8010

\# dev 开发环境配置文件 |  test 测试环境  |  pro 正式环境
\# 和git里的文件名对应
spring.cloud.config.profile=test

\# 配置服务中心的地址
\#spring.cloud.config.uri=http://localhost:8002/
eureka.client.serviceUrl.defaultZone=http://localhost:1111/eureka/
\#从配置中心读取文件
spring.cloud.config.discovery.enabled=true
\#配置中心的servieId，即服务名
spring.cloud.config.discovery.serviceId=config-server

\# 远程仓库的分支名
spring.cloud.config.label=master
```


访问：http://localhost:8010/v

返回：

```
project:config-client-1,value=1
```


