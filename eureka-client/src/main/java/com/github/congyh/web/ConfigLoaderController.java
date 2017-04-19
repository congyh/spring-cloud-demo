package com.github.congyh.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href='mailto:yihao.cong@outlook.com'>Cong Yihao</a>
 */
@RefreshScope // 每次访问都会创建一个新实例, 适合用于更新配置信息.
@RestController
public class ConfigLoaderController {

    @Value("${from}")
    private String from;

    @RequestMapping("/from")
    public String from() {
        return from;
    }
}
