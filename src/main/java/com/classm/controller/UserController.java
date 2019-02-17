package com.classm.controller;


import com.classm.bean.JsonEntity;
import com.classm.bean.ResponseHelper;
import com.classm.bean.User;
import com.classm.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api
@RestController
@RequestMapping(value = "/security/user")
public class UserController {

    @Autowired
    private UserService userService;

    public String login(@RequestParam String userName) {
        return "";
    }


    @GetMapping(value = "/all")
    @ApiOperation(value = "get all users")
    public JsonEntity<List<User>> getAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        return ResponseHelper.of(allUsers);
    }
}
