package com.github.congyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@EnableAuthorizationServer
@EnableDiscoveryClient
@SpringBootApplication
public class OauthAuthorizationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthAuthorizationServerApplication.class, args);
	}
}
