package com.wangc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author gnehcgnaw
 * @date 2018年09月15日17:14:50
 * 在服务提供方添加EnableHystrix
 */
@EnableHystrix
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@MapperScan("com.wangc.order.mapper")
public class ProviderOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderOrderApplication.class, args);
    }
}
