package com.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.provider.entity.User;
import com.provider.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yan on 2019/2/15.
 */
@Controller
public class UserController {
    @Reference
    private IUserService userService;

    @RequestMapping("getUser/{id}")
    @ResponseBody
    public User getUser(@PathVariable("id") int id){
        return userService.getUser(id);
    }
}
