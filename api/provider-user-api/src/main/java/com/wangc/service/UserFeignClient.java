package com.wangc.service;

import com.wangc.entity.User;
import com.wangc.service.hystrix.UserFeignApiHystrix;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author gnehcgnaw
 * @date 2018年09月18日11:59:08
 */

@RefreshScope
@FeignClient(name = "${user.service.name}" , fallback = UserFeignApiHystrix.class)
public interface UserFeignClient {

    @GetMapping("/user/{id}")
    User getUser(@PathVariable(value = "id") Long id) ;

}
