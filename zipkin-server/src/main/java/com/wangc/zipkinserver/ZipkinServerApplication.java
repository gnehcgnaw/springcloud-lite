package com.wangc.zipkinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

/**
 * Zipkin-server启动类
 * @author gnehcgnaw
 * @date 2018年09月28日
 */
/**
 * 使用Stream方式启动ZipkinServer
 */
@EnableZipkinStreamServer
@SpringBootApplication
public class ZipkinServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerApplication.class, args);
    }
}
