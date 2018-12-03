package com.wangc.service.hystrix;

import com.wangc.entity.User;
import com.wangc.service.UserFeignClient;

/**
 * @author: gnehcgnaw
 * @date: 2018-12-03 15:04
 */
public class UserFeignApiHystrix implements UserFeignClient {
    @Override
    public User getUser(Long id) {
        return new User();
    }
}
