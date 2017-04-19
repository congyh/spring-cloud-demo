# Eureka client

> 是微服务架构中实际**提供服务的主体**.

通过`POST`到/refresh地址, 强制触发SpringBoot工程的重新配置(如果是从Config Server获取配置的话也可以获得实时的更新的配置.)

