package com.wangc.getwayzuulproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * ZuulProxy
 * @author gnehcgnaw
 * @date  2018年09月20日
 */

/**
 * @SpringCloudApplication 包含以下注解
 * 		@SpringBootApplication
 * 		@EnableDiscoveryClient
 * 		@EnableCircuitBreaker
 */
@EnableZuulProxy
@SpringCloudApplication
public class GetwayZuulProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetwayZuulProxyApplication.class, args);
	}
}
