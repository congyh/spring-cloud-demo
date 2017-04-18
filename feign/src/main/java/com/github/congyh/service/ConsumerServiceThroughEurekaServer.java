package com.github.congyh.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author <a href='mailto:yihao.cong@outlook.com'>Cong Yihao</a>
 */
@FeignClient("EUREKA-CLIENT-SERVICE") // 自带负载均衡, 底层也是通过ribbon实现的
public interface ConsumerServiceThroughEurekaServer {

    @GetMapping(value = "/add") // 这里注意接口定义要与被消费的REST服务一致
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
}
