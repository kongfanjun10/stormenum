package com.yan.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.yan.entity.User;
import com.yan.mapper.RedisMapper;
import com.yan.service.RedisService;
import com.yan.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;


import java.util.List;

/**
 * Created by yan on 2019/2/18.
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisMapper redisMapper;

    @Override
    public List<User> selectUser() {
        //获取jedis实例
        Jedis jedis = RedisUtil.getJedis();
        //判断Redis中是否存在userList,没有-->则通过mapper查询数据库返回-->并储存在Redis中,
        //有则从Redis缓存中直接返回
        if(!jedis.exists("userList")){
            try {
                List<User> userList = redisMapper.selectUser();
                //将User集合转化为String
                String strUserList = JSONObject.toJSONString(userList);
                //存放到Redis中
                jedis.set("userList", strUserList);
                //设置Key过期时间
                RedisUtil.expire("userList", 300);
                return userList;
            } finally {
                //关流,还不如直接close()呢
                RedisUtil.closeJedisResource(jedis);
            }
        }else{
            try {
                //从Redis中取出userList,并转换为集合
                String strUserList = jedis.get("userList");
                List<User> userList = JSONObject.parseArray(strUserList,User.class);
                return userList;
            } finally {
                RedisUtil.closeJedisResource(jedis);
            }
        }
    }
}
