package com.github.congyh.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author <a href='mailto:yihao.cong@outlook.com'>Cong Yihao</a>
 */
//@FeignClient(value = "EUREKA-CLIENT-SERVICE", fallback = ConsumerServiceThroughEurekaServerImpl.class) // 自带负载均衡, 底层也是通过ribbon实现的, 这里还添加了Hystrix熔断支持
@FeignClient(value = "EUREKA-CLIENT-SERVICE")
public interface ConsumerServiceThroughEurekaServer {

    // 这里注意接口定义要与被消费的REST服务一致
    @GetMapping(value = "/add")
    Integer add(@RequestParam("a") Integer a, @RequestParam("b") Integer b);
}
