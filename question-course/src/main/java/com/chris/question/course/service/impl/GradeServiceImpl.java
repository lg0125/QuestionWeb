package com.chris.question.course.service.impl;

import com.chris.question.course.dao.GradeMapper;
import com.chris.question.course.pojo.Grade;
import com.chris.question.course.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service("GradeService")
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public int insertGrade(Grade grade) {
        return gradeMapper.insertGrade(grade);
    }

    @Override
    public int deleteGrade(Long gradeId) {
        return gradeMapper.deleteGrade(gradeId);
    }

    @Override
    public int updateGrade(Grade grade) {
        return gradeMapper.updateGrade(grade);
    }

    @Override
    public Grade getGrade(Long gradeId) {
        return gradeMapper.getGrade(gradeId);
    }

    @Override
    public List<Grade> getGradeListBySchoolId(Long schoolId) {
        return gradeMapper.getGradeListBySchoolId(schoolId);
    }

    @Override
    public List<Grade> getGradeList() {
        return gradeMapper.getGradeList();
    }
}
