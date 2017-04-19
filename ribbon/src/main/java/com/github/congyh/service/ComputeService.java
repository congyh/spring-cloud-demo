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

    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String addService(Integer a, Integer b) {
        return restTemplate.getForEntity(
            EUREKA_CLIENT_SERVICE_ADD
                + "?a=" + a
                + "&b=" + b, String.class).getBody();
    }

    public String addServiceFallback() {
        return "Service temporary cannot reach!";
    }
}
