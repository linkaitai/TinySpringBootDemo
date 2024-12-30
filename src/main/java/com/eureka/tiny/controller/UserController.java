package com.eureka.tiny.controller;

import com.eureka.tiny.anno.Log;
import com.eureka.tiny.pojo.Result;
import com.eureka.tiny.pojo.User;
import com.eureka.tiny.service.UserService;
import com.eureka.tiny.utils.JwtUtil;
import com.eureka.tiny.utils.ThreadLocalUtil;
import jakarta.websocket.OnClose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("/register")
    public Result register(String username, String password) {
        User user = userService.findUsername(username);
        if (!userService.isUsernameExists(username)) {
            userService.register(username, password);
            return Result.success();
        } else {
            return Result.error("用户名已存在");
        }
    }

    @PostMapping("/login")
    public Result login(String username, String password) {
        User user = userService.findUsername(username);
        if (user == null) {
            return Result.error("用户不存在");
        }

        if (password.equals(user.getPassword())) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", user.getId());
            claims.put("username", user.getUsername());
            String token = JwtUtil.genToken(claims);

            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            operations.set(token, token);
            return Result.success(token);
        }

        return Result.error("密码错误");
    }


    @GetMapping("/userInfo")
    public Result<User> userInfo() {
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User user = userService.findUsername(username);
        return Result.success(user);
    }

    @Log
    @PutMapping("/update")
    public Result update(@RequestBody User user) {
        userService.update(user);
        return Result.success();
    }

    @Log
    @PatchMapping("/updatePwd")
    public Result updatePwd(@RequestBody Map<String, String> params, @RequestHeader("Authorization") String token) {
        String oldPwd = params.get("old_pwd");
        String newPwd = params.get("new_pwd");
        String rePwd = params.get("re_pwd");
        if (!StringUtils.hasLength(oldPwd) || !StringUtils.hasLength(newPwd) || !StringUtils.hasLength(rePwd)) {
            return Result.error("参数不合法");
        }

        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User user = userService.findUsername(username);

        if (!oldPwd.equals(user.getPassword())) {
            return Result.error("原密码错误");
        }
        if (!newPwd.equals(rePwd)) {
            return Result.error("两次输入的密码不同");
        }
        userService.updatePwd(newPwd);
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.getOperations().delete(token);
        return Result.success();
    }


}
