package com.yupi.wlsdbackend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yupi.wlsdbackend.common.R;
import com.yupi.wlsdbackend.domain.IntegralDetail;
import com.yupi.wlsdbackend.domain.User;
import com.yupi.wlsdbackend.service.UserService;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.yupi.wlsdbackend.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    //    接收前端发来的login请求
    @PostMapping("/user/login")
    public R<User> login(HttpServletRequest request, @RequestBody User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone_number", user.getPhoneNumber()).eq("user_password", user.getUserPassword());
//        log.info((userService.getOne(queryWrapper).getPhoneNumber()));
        if (userService.getOne(queryWrapper) == null) {
            return R.error("账号或密码错误");
        }
        User aUser = new User();

        aUser.setPhoneNumber(user.getPhoneNumber());
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userService.getOne(queryWrapper).getUserId());
        claims.put("phoneNumber", userService.getOne(queryWrapper).getPhoneNumber());
        claims.put("userName", userService.getOne(queryWrapper).getUserName());

        String jwt = JwtUtils.generateJwt(claims);
        aUser.setJwt(jwt);
        log.info(jwt);
        return R.success(aUser);
    }

    //        通过手机号来判断是哪个学生
    @GetMapping("/getUserMsg")
    public User getUserMsg(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;

        User aUser;
//        判断收到的jwt有没有bear
        String jwt = req.getHeader("Authorization");
        log.info(jwt);
        String[] jwt2 = jwt.split(" ");
        Map<String, Object> claims2;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        if (jwt2.length == 1) {
            log.info("JWT" + jwt);
            claims2 = JwtUtils.parseJWT(jwt);
            queryWrapper.eq("phone_number", (String) claims2.get("phoneNumber"));
//        通过phoneNum来获取数据
//            aUser = userService.getInfo((String) claims2.get("phoneNumber"));
        } else {
            log.info("JWT" + jwt2[1]);
            claims2 = JwtUtils.parseJWT(jwt2[1]);
            queryWrapper.eq("phone_number", (String) claims2.get("phoneNumber"));
//            aUser = userService.getInfo((String) claims2.get("phoneNumber"));
        }
        aUser = userService.getOne(queryWrapper);
        return aUser;
    }

}
