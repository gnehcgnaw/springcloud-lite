package com.wangc.provideruac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author gnehcgnaw
 * @date 2018年09月15日17:14:50
 * 在服务提供方添加EnableHystrix
 */
@EnableHystrix
@EnableDiscoveryClient
@SpringBootApplication
public class ProviderUacApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderUacApplication.class, args);
	}
}
