package com.github.congyh.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href='mailto:yihao.cong@outlook.com'>Cong Yihao</a>
 */
@RestController
public class ComputeController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping(value = "/add")
    public Integer add(@RequestParam("a") Integer a,
                       @RequestParam("b") Integer b) {

        Integer res = a + b;
        logger.info("result: {}", res);

        return res;
    }
}
