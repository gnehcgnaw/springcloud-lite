package com.wangc.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wangc.entity.User;
import com.wangc.mapper.UserMapper;
import com.wangc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 内存实现{@link UserService}
 *
 * @author gnehcgnaw
 * @date 2018年09月15日15:02:31
 * @since 0.0.1
 */

@SuppressWarnings("all")
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.selectList(null);
    }

    @Override
    public User findById(Long i) {
        Wrapper<User> queryMapper = new QueryWrapper<>();
        ((QueryWrapper<User>) queryMapper).eq("id",i);
        List<User> users = userMapper.selectList(queryMapper);
        return users.get(0);
    }
}
