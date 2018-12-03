package com.wangc.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wangc.service.UserService;
import com.wangc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@SuppressWarnings("all")
@RefreshScope
@RestController
public class UserController  {

    @SuppressWarnings("all")
    @Autowired
    private UserService userService;

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 添加超时判断
     *
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallbackFotGetUsers")
    @GetMapping("/user/list")
    public List<User> getUses() {
        return userService.findAll();
    }

    /**
     * fallbackMethod
     *
     * @return
     */
    public List<User> fallbackFotGetUsers() {
        return Collections.emptyList();
    }


    @GetMapping("/testRoundRobinRule")
    public String getServiceInstance() {
        List<ServiceInstance> instances = this.discoveryClient.getInstances("provider-user-service");
        String serviceInstanceMessages = instances.get(0).getUri().toString();
        return serviceInstanceMessages;
    }
    @GetMapping("/user/{id}")
    public User getById(@PathVariable(name = "id") Long id){
        return userService.findById(id);
    }

}
