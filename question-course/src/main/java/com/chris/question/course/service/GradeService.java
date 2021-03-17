package com.chris.question.course.service;

import com.chris.question.course.pojo.Grade;

import java.math.BigInteger;
import java.util.List;

public interface GradeService {
    public int insertGrade(Grade grade);
    public int deleteGrade(Long gradeId);
    public int updateGrade(Grade grade);
    public Grade getGrade(Long gradeId);
    public List<Grade> getGradeListBySchoolId(Long schoolId);
    public List<Grade> getGradeList();
}
