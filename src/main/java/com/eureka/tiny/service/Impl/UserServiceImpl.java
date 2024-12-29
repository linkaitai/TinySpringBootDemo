package com.eureka.tiny.service.Impl;

import com.eureka.tiny.mapper.UserMapper;
import com.eureka.tiny.pojo.User;
import com.eureka.tiny.service.UserService;
import com.eureka.tiny.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public boolean isUsernameExists(String username) {
        return userMapper.findByUsername(username) != null;
    }

    @Override
    public void register(String username, String password) {
        userMapper.add(username, password);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void updatePwd(String newPwd) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        userMapper.updatePwd(newPwd, id);
    }


}
