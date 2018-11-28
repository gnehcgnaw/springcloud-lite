package com.wangc;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableDiscoveryClient
@EnableAdminServer
@SpringBootApplication
@EnableTurbine
public class CloudMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudMonitorApplication.class, args);
	}

}
