//package com.github.congyh.service.impl;
//
//import com.github.congyh.service.ConsumerServiceThroughEurekaServer;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
///**
// * @author <a href='mailto:yihao.cong@outlook.com'>Cong Yihao</a>
// */
//@Service
//public class ConsumerServiceThroughEurekaServerImpl implements ConsumerServiceThroughEurekaServer {
//
//    /**
//     * 本方法是用于支持熔断的功能降级
//     */
//    @GetMapping("/add")
//    public Integer add(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
//        return -9999;
//    }
//}
