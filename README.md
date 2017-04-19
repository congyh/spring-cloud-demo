# Spring Cloud demo

启用顺序:

1. RabbitMQ
1. Config Server
1. Zuul
1. Eureka Server
1. Eureka Client(建议启动多个实例)
1. Ribbon, Feign

原理:

1. Config Server启动, 为所有Spring Cloud组件提供配置文件做准备.
1. Zuul为所有Eureka Server注册过的服务提供前端路由功能.
1. Eureka Server启动, 从Config Server获取配置文件. 启动后作为Service注册中心.
1. Eureka Client启动, 从Config Server获取配置文件, 启动后注册到Eureka Server.
1. 启动第二个相同服务的Eureka Client, 用于后续Ribbon, Feign的负载均衡. 建议通过下面的方式启动:
   
   ```bash
   mvn spring-boot:run -Dserver.port=8081
   ```
1. RabbitMQ为所有连接到它的服务提供一个/bus/refresh接口, 从Config Server获取最新的配置信息.
1. Ribbon启动, 通过Ribbon的带有负载均衡的RestTemplate消耗前面Eureka Client提供的服务, 可以通过查看同一服务下不同Eureka Client实例的日志来确认负载均衡生效; Feign是对Ribbon的一层封装