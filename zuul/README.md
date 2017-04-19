# Zuul

> 服务网关, 是微服务架构提供对外访问的最前端. 提供路由功能, 统一暴露内部Eureka服务中心的REST服务.

一些服务间通用的模块可以放置在这里, 例如: 权限控制.

![zuul-filter](./etc/zuul-filter.png)

Zuul + Eureka, 能够快速根据Eureka中注册的`serviceId`进行映射, 达到智能路由的目的.