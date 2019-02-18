package com.yan.controller;

import com.yan.entity.User;
import com.yan.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

/**
 * Created by yan on 2019/2/18.
 */
@Controller
public class RedisController {
    @Autowired
    private RedisService redisService;

    @RequestMapping("test")
    @ResponseBody
    public String test(){
        return "测试成功";
    }

    @RequestMapping("selectUserList")
    public String selectUserList(ModelMap map){
        List<User> userList = redisService.selectUser();
        map.put("userList",userList);
        return "user";
    }

}
