package com.wangc.getwayzuulproxy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

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
@EnableDiscoveryClient
public class GetwayZuulProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetwayZuulProxyApplication.class, args);
	}

	/**
	 * 动态路由,从config-server中拉取配置
	 */
	@Qualifier("zuulProperties")
	@RefreshScope
	@ConfigurationProperties("zuul")
	public ZuulProperties zuulProperties(){
		return new ZuulProperties();
	}
}
