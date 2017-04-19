# Config Server

启动工程后, Config Server会在8888端口(根据配置文件确定)监听. 可以访问以下网址来尝试获取不同的配置文件:

- [获取src/main/resources/compute-service.properties配置内容](http://localhost:8888/compute-service/default)
- [获取src/main/resources/compute-service-dev.properties配置内容](http://localhost:8888/compute-service/dev)


URL与配置文件的映射关系如下：

*   /{application}/{profile}[/{label}]
*   /{application}-{profile}.yml
*   /{label}/{application}-{profile}.yml
*   /{application}-{profile}.properties
*   /{label}/{application}-{profile}.properties

