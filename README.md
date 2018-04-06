# SpringCloud

---


## 核心模块

* 配置服务

集中存储所有应用的配置文件

* 服务发现

Eureka Server为微服务注册中心

* 路由网关

让所有的微服务对外只有一个接口，由网关将我们的请求代理到不同的服务中

* 负载均衡

提供了Ribbon和Feign作为客户端的负载均衡。

* 断路器

为了解决某个方法调用失败的时候，调用后备方法来替代失败的方法，达到容错目地。


## 工程案例

* [服务消费者（ribbon+rest）](consumer-ribbon)
	* ribbon是一个负载均衡客户端，可以很好的控制http和tcp。示例包含一个注册中心，两个服务提供者，一个消费者
* [服务消费者（Feign）](consumer-feign)
	* Feign是一个声明式的伪Http客户端，它使得写Http客户端变得更简单。使用Feign，只需要创建一个接口并注解。它具有可插拔的注解特性，可使用Feign 注解和JAX-RS注解。Feign支持可插拔的编码器和解码器。Feign默认集成了Ribbon，并和Eureka结合，默认实现了负载均衡的效果。
* [网关gateway](gateway)
	* 包含注册中心、若干服务提供方、网关消费方
* [config](config)
	* 分布式配置中心组件，方便服务配置文件统一管理，实时更新

