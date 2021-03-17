package com.chris.question.course.dao;

import com.chris.question.course.pojo.School;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface SchoolMapper {
    public int insertSchool(School school);
    public int deleteSchool(Long id);
    public int updateSchool(School school);
    public School getSchool(Long id);
    public List<School> getSchoolList();
}
