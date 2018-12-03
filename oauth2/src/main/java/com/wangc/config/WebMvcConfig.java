package com.wangc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * 在springboot2.0及spring5.0之后${@link org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter}已被废弃，
 * 官方推荐使用${@link WebMvcConfigurer}
 * @author: gnehcgnaw
 * @date: 2018-12-02 13:13
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    //todo

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/oauth/confirm_access").setViewName("authorize");
    }
}
