package com.wangc.consumerfeign.clientfallback;

import com.wangc.consumerfeign.client.UserFeignClient;
import com.wangc.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author gnehcgnaw
 */
@Component
public class UserFeignClientFallback  implements UserFeignClient {
    @Override
    public User getUser(String id) {
        User user = new User("UserFeignClientFallback_userId" ,"UserFeignClientFallback_userName") ;
        return user;
    }

    @Override
    public String getServiceInstance() {
        return null;
    }

    @Override
    public boolean saveUser(User user) {
        return false;
    }
}
