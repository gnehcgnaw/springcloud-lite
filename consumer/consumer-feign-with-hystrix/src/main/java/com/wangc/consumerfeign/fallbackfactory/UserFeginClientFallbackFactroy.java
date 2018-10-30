package com.wangc.consumerfeign.fallbackfactory;

import com.wangc.consumerfeign.client.UserFeignClient;
import com.wangc.entity.User;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * FallbackFactory方式
 * @author gnehcgnaw
 * @date 2018年09月18日22:22:50
 */
@Slf4j
@Component
public class UserFeginClientFallbackFactroy  implements FallbackFactory<UserFeignClient> {

    @Override
    public UserFeignClient create(Throwable cause) {
        return new UserFeignClient() {
            @Override
            public User getUser(String id) {
                //当fegin发生回退的时候，打印日志信息
                UserFeginClientFallbackFactroy.log.info("User.getUser() fallback due to: {}" ,cause.getMessage());
                User user = new User("UserFeginClientFallbackFactroy_userId" ,"UUserFeginClientFallbackFactroy_userName") ;
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
        };
    }
}
