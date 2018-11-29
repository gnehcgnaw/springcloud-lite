package com.wangc.provideruac.service;

import com.wangc.api.UserService;
import com.wangc.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 内存实现{@link UserService}
 * @author gnehcgnaw
 * @date 2018年09月15日15:02:31
 * @since 0.0.1
 */
@Service
public class InMemoryUserService implements UserService {

    private Map<String, User> repository = new ConcurrentHashMap<>();
    @Override
    public boolean saveUser(User user) {
         return repository.put(user.getUserId(),user) == null ;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(repository.values());
    }
}
