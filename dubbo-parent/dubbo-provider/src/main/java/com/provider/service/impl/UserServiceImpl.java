package com.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;

import com.provider.entity.User;
import com.provider.mapper.UserMapper;
import com.provider.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yan on 2019/2/15.
 */
@Service
@org.springframework.stereotype.Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(int id) {

        return userMapper.getUser(id);
    }
}
