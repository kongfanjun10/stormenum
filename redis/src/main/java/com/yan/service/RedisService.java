package com.yan.service;


import com.yan.entity.User;

import java.util.List;

/**
 * Created by yan on 2019/2/18.
 */
public interface RedisService {
    List<User> selectUser();
}
