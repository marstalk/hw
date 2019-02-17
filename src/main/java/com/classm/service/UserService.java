package com.classm.service;

import com.classm.bean.User;
import com.classm.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUsers() {
        return userMapper.getAll();
    }

    public User findUserByEmail(String email) {
        return userMapper.findUserByEmail(email);
    }

    public User findUserByPhone(String phone) {
        return userMapper.findUserByPhone(phone);
    }

    public User findUserById(int id) {
        return userMapper.findUserById(id);
    }
}
