package com.chris.question.user.dao;

import com.chris.question.user.dto.UserDto;
import com.chris.question.user.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public User getUser(String id);
    public int insertUser(UserDto userDto);
    public int updateUser(UserDto userDto);
}
