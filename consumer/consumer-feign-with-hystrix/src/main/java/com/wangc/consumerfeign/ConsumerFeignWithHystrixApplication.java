package com.wangc.consumerfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * ConsumerFeignHystrix启动类
 * @author gnehcgnaw
 * @date  2018年09月17日22:58:33
 */

/**
 * 在使用fegin的fallback的功能的时候可以不用添加@EnableCircuitBreaker，但是fegin的maven中没有hystrix-metrics-event-steeam，
 * 而这个依赖在spring-cloud-starter-hystrix中，所以要想启动Hystrix的监控需要引入spring-cloud-starter-hystrix ，并且添加
 * @EnableCircuitBreaker 注解，但这种方式只能监控一个服务中的信息，所以需要使用Turbine，并且使用mq的方式将fallback问题发送给Turbine，
 * 这样可以保证在网路不畅通的情况下也能够收集到信息。
 */
@EnableCircuitBreaker
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerFeignWithHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerFeignWithHystrixApplication.class, args);
	}
}
