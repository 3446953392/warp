package com.yupi.wlsdbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.wlsdbackend.domain.User;
import com.yupi.wlsdbackend.service.UserService;
import com.yupi.wlsdbackend.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 95788
 * @description 针对表【user(用户)】的数据库操作Service实现
 * @createDate 2024-01-31 11:56:30
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
}