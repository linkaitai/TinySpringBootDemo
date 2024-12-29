package com.eureka.tiny.service;

import com.eureka.tiny.pojo.User;

import java.util.Map;


public interface UserService {
    User findUsername(String username);

    boolean isUsernameExists(String username);

    void register(String username, String password);

    void update(User user);

    void updatePwd(String newPwd);
}
