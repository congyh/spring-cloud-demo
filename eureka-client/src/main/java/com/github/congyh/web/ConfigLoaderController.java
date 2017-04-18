package com.github.congyh.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href='mailto:yihao.cong@outlook.com'>Cong Yihao</a>
 */
// @RefreshScope
@RestController
public class ConfigLoaderController {

    @Value("${from}")
    private String from;

    @RequestMapping("/from")
    public String from() {
        return from;
    }
}
