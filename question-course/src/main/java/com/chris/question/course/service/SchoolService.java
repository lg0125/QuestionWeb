package com.chris.question.course.service;

import com.chris.question.course.pojo.School;

import java.math.BigInteger;
import java.util.List;

public interface SchoolService {
    public int insertSchool(School school);
    public int deleteSchool(Long schoolId);
    public int updateSchool(School school);
    public School getSchool(Long schoolId);
    public List<School> getSchoolList();
}
