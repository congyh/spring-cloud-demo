# Eureka Server Sample

mvn spring-boot:run ,It will start up on port 8761.

## Resources

| Path             | Description  |
|------------------|--------------|
| /                        | Home page (HTML UI) listing service registrations          |
| /eureka/apps         | Raw registration metadata |

## Docker Container

There is a Maven goal (using a [plugin](https://github.com/spring-cloud-samples/eureka/blob/feature/docker/pom.xml#L48)) to 
generate the Docker container. The container is published in dockerhub at `springcloud/eureka`.