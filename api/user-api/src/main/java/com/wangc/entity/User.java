package com.wangc.entity;


import java.io.Serializable;

/**
 * @author gnehcgnaw
 * @date 2018年09月21日10:24:47
 */
public class User implements Serializable {

    private static final long serialVersionUID = -3049598400081477135L;

    public User(String userId, String userName) {

        this.userId = userId;
        this.userName = userName;
    }

    public User() {
    }

    private String userId;
    private String userName ;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
