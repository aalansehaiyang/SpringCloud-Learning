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
	* ribbon是一个负载均衡客户端，可以很好的控制http和tcp。示例包含一个注册中心，一个双实例服务提供者，一个消费者
* [服务消费者（Feign）](consumer-feign)
	* Feign是一个声明式的伪Http客户端，它使得写Http客户端变得更简单。使用Feign，只需要创建一个接口并注解。它具有可插拔的注解特性，可使用Feign 注解和JAX-RS注解。Feign支持可插拔的编码器和解码器。Feign默认集成了Ribbon，并和Eureka结合，默认实现了负载均衡的效果。
* [服务网关（zuul）](gateway)
	* Zuul的主要功能是路由转发和过滤器。路由功能是微服务的一部分，比如 /api/user转发到user服务，/api/shop转发到到shop服务。zuul默认和Ribbon结合实现了负载均衡的功能。
	* 包含三个注册中心（高可用的服务注册中心），两个单实例服务提供者、一个网关消费方
* [分布式配置（config）](config)
	* 分布式配置中心组件，方便服务配置文件统一管理，实时更新
* [高可用分布式配置（config）](high-availability-config)
	* 示例包含一个注册中心，三个config-server服务提供者实例，一个消费者
* [断路器（Hystrix）](hystrix)
	* 系统的自动降级保护。特定的服务的调用的不可用达到一个阀值（Hystric 是5秒20次） 断路器将会被打开。

