package com.wangc.api;

import com.wangc.entity.User;

import java.util.List;

/**
 * 用户服务
 * @author gnehcgnaw
 * @date 2018年09月15日14:53:27
 */
public interface UserService {
    /**
     * 保存用户
     * @param user
     * @return
     *
     */
    boolean saveUser(User user);

    /**
     * 查询所有用户列表
     *
     * @return  non-null
     */
    List<User> findAll();
}
