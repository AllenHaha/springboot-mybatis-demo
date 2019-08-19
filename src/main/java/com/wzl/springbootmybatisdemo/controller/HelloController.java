package com.wzl.springbootmybatisdemo.controller;

import com.wzl.springbootmybatisdemo.mapper.UserMapper;
import com.wzl.springbootmybatisdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
public class HelloController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        User user = userMapper.getUserById(id);
        return user;
    }
}
