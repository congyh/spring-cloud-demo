# Config Server

启动工程后, Config Server会在8888端口(根据配置文件确定)监听. 可以访问以下网址来尝试获取不同的配置文件:

- [获取src/main/resources/eureka-client-service.properties配置内容](http://localhost:8888/eureka-client-service/default)
- [获取src/main/resources/eureka-client-service.properties配置内容](http://localhost:8888/eureka-client-service/dev)


URL与配置文件的映射关系如下：

*   /{application}/{profile}[/{label}]
*   /{application}-{profile}.yml
*   /{label}/{application}-{profile}.yml
*   /{application}-{profile}.properties
*   /{label}/{application}-{profile}.properties

## 服务配置更新

### 单个更新

通过`POST`到/refresh地址, 强制触发SpringBoot工程的重新配置(如果是从Config Server获取配置的话也可以获得实时的更新的配置.)

### 使用Spring Cloud Bus作为消息总线, 实现整体更新

原理: 多个订阅到同一个RabbitMQ的服务, 只要有一个服务访问`/bus/refresh`接口, 就会将刷新请求发送到RabbitMQ中, 其他实例会从RabbitMQ中获取这个事件, 从Config Server中获取配置信息.

通常我们是通过将Config Server也连接到消息总线上, 这样子我们只需要向Config Server发送更新配置的请求, 就可以触发所有连接到总线上的服务的配置更新.

### 指定刷新范围

Spring Cloud Bus对这种场景也有很好的支持：`/bus/refresh`接口还提供了`destination`参数，用来定位具体要刷新的应用程序。比如，我们可以请求`/bus/refresh?destination=customers:9000`，此时总线上的各应用实例会根据`destination`属性的值来判断是否为自己的实例名，若符合才进行配置刷新，若不符合就忽略该消息。

`destination`参数除了可以定位具体的实例之外，还可以用来定位具体的服务。定位服务的原理是通过使用Spring的PathMatecher（路径匹配）来实现，比如：`/bus/refresh?destination=customers:**`，该请求会触发`customers`服务的所有实例进行刷新。
