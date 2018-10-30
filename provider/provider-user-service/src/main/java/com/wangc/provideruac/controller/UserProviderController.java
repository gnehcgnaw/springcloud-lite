package com.wangc.provideruac.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wangc.api.UserService;
import com.wangc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RefreshScope
@RestController
public class UserProviderController {

    @SuppressWarnings("all")
    @Autowired
    private UserService userService ;

    @Autowired
    private DiscoveryClient discoveryClient ;


    @Value("${user.userId}")
    private String userId;

    @Value("${user.userName}")
    private String userName ;
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable(value = "id") String id){
        if(id!=null){
            return new User(userId,userName);
        }else{
            return null;
        }
    }

    @PostMapping("/user/save")
    public boolean saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    /**
     * 添加超时判断
     * @return
     */
    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMillseconds", value = "100")
            },
            fallbackMethod = "fallbackFotGetUsers"
    )
    @GetMapping("/user/list")
    public List<User> getUses(){
        return userService.findAll();
    }

    /**
     * fallbackMethod
     * @return
     */
    public List<User> fallbackFotGetUsers(){
        return Collections.emptyList();
    }


    @GetMapping("/testRoundRobinRule")
    public String getServiceInstance(){
        ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
        String serviceInstanceMessages = localServiceInstance.getUri().toString();
        return serviceInstanceMessages ;
    }
}
