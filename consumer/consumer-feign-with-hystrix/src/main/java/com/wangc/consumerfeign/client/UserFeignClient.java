package com.wangc.consumerfeign.client;

import com.wangc.consumerfeign.clientfallback.UserFeignClientFallback;
import com.wangc.consumerfeign.fallbackfactory.UserFeginClientFallbackFactroy;
import com.wangc.entity.User;
import com.wangc.feign.config.FeignLogConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author gnehcgnaw
 * @date 2018年09月18日11:59:08
 */

/**
 * 使用fallback模式：
 *      @FeignClient(name = "PROVIDER-USER-SERVICE" ,
 *             configuration = FeignLogConfiguration.class,
 *             fallback = UserFeignClientFallback.class)        ${@link UserFeignClientFallback}
 *
 *
 */
@RefreshScope
@FeignClient(name = "${user.service.name}" ,
            configuration = FeignLogConfiguration.class ,
            fallbackFactory = UserFeginClientFallbackFactroy.class)
public interface UserFeignClient {

    @GetMapping("/user/{id}")
    User getUser(@PathVariable(value = "id") String id) ;

    @GetMapping("/testRoundRobinRule")
    String getServiceInstance() ;

    @PostMapping("/user/save")
    boolean saveUser(@RequestBody User user) ;
}
