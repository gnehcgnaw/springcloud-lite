package com.wangc.consumerfeign.controller;

import com.wangc.consumerfeign.client.UserFeignClient;
import com.wangc.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author gnehcgnaw
 * @date 2018年09月17日13:27:33
 */

@Slf4j
@RestController
public class UserFeignController {
    @SuppressWarnings("all")
    @Autowired
    private UserFeignClient userFeignClient ;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable(value = "id") String id) {
        return  userFeignClient.getUser(id);
    }

    @GetMapping("/testRoundRobinRule")
    public String getServiceInstance(){
        return userFeignClient.getServiceInstance();
    }

    @PostMapping("/user/save")
    public boolean saveUser(@RequestBody User user){
        return userFeignClient.saveUser(user);
    }

}
