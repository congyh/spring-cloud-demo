package com.github.congyh.web;

import com.github.congyh.service.ConsumerServiceThroughEurekaServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href='mailto:yihao.cong@outlook.com'>Cong Yihao</a>
 */
@RestController
public class ConsumerController {

    @Autowired
//    @Qualifier("consumerServiceThroughEurekaServer")
    private ConsumerServiceThroughEurekaServer serviceProvider;

    @GetMapping(value = "/add")
    Integer add(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        return serviceProvider.add(a, b);
    }
}
