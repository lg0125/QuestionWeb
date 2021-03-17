package com.chris.question.course.dao;

import com.chris.question.course.pojo.Grade;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface GradeMapper {
    public int insertGrade(Grade grade);
    public int deleteGrade(Long id);
    public int updateGrade(Grade grade);
    public Grade getGrade(Long id);
    public List<Grade> getGradeListBySchoolId(Long schoolId);
    public List<Grade> getGradeList();
}
