package com.github.congyh.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author <a href='mailto:yihao.cong@outlook.com'>Cong Yihao</a>
 */
@Service
public class ComputeService {

    @Autowired
    private RestTemplate restTemplate;

    private final String EUREKA_CLIENT_SERVICE_ADD =
        "http://EUREKA-CLIENT-SERVICE/add";

    /**
     * 带有Hystrix服务降级功能的服务
     *
     * <p>注意: 服务降级时, 方法签名应该一致.
     *
     * @param a 第一个加数
     * @param b 第二个加数
     * @return 相加的结果
     */
    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String addService(Integer a, Integer b) {
        return restTemplate.getForEntity(
            EUREKA_CLIENT_SERVICE_ADD
                + "?a=" + a
                + "&b=" + b, String.class).getBody();
    }

    /**
     * Hystrix提供的服务降级方法
     */
    public String addServiceFallback(Integer a, Integer b) {
        return "Service temporary cannot reach!";
    }
}
