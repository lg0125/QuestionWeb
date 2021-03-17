package com.chris.question.user.service;


import com.chris.question.user.dto.UserDto;
import com.chris.question.user.pojo.User;

public interface UserService {
    public User getUser(String id);
    public int insertUser(UserDto userDto);
    public int updateUser(UserDto userDto);
}
