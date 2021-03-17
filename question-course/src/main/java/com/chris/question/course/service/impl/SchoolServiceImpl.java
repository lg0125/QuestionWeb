package com.chris.question.course.service.impl;

import com.chris.question.course.dao.SchoolMapper;
import com.chris.question.course.pojo.School;
import com.chris.question.course.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service("SchoolService")
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolMapper schoolMapper;

    @Override
    public int insertSchool(School school) {
        return schoolMapper.insertSchool(school);
    }

    @Override
    public int deleteSchool(Long schoolId) {
        return schoolMapper.deleteSchool(schoolId);
    }

    @Override
    public int updateSchool(School school) {
        return schoolMapper.updateSchool(school);
    }

    @Override
    public School getSchool(Long schoolId) {
        return schoolMapper.getSchool(schoolId);
    }

    @Override
    public List<School> getSchoolList() {
        return schoolMapper.getSchoolList();
    }
}
