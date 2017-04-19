package com.github.congyh.web;

import com.github.congyh.service.ComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href='mailto:yihao.cong@outlook.com'>Cong Yihao</a>
 */
@RestController
public class ConsumerServiceThroughEurekaController {

//    @Autowired
//    private RestTemplate restTemplate;
    @Autowired
    private ComputeService computeService;

//    private final String EUREKA_CLIENT_SERVICE_ADD =
//        "http://EUREKA-CLIENT-SERVICE/add";

    /**
     * 使用带负载均衡的restTemplate调用在Eureka Server注册的
     * 名为EUREKA-CLIENT-SERVICE的service的add路径下的方法
     *
     * @param a 第一个加数
     * @param b 第二个加数
     * @return 两数的和
     */
    @GetMapping(value = "/add")
    public String add(@RequestParam("a") Integer a,
                      @RequestParam("b") Integer b) {
        return computeService.addService(a, b);
    }
}
