package com.chris.question.user.service.impl;

import com.chris.question.user.dao.UserMapper;
import com.chris.question.user.dto.UserDto;
import com.chris.question.user.pojo.User;
import com.chris.question.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String id) {
        return userMapper.getUser(id);
    }

    @Override
    public int insertUser(UserDto userDto) {
        return userMapper.insertUser(userDto);
    }

    @Override
    public int updateUser(UserDto userDto) {
        return userMapper.updateUser(userDto);
    }
}
