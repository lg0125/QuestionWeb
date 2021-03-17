package com.chris.question.course.service.impl;

import com.chris.question.course.dao.CourseTypeMapper;
import com.chris.question.course.pojo.CourseType;
import com.chris.question.course.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CourseTypeService")
public class CourseTypeServiceImpl implements CourseTypeService {

    @Autowired
    private CourseTypeMapper courseTypeMapper;

    @Override
    public int insertCourseType(CourseType courseType) {
        return courseTypeMapper.insertCourseType(courseType);
    }

    @Override
    public int deleteCourseType(String courseTypeId) {
        return courseTypeMapper.deleteCourseType(courseTypeId);
    }

    @Override
    public int updateCourseType(CourseType courseType) {
        return courseTypeMapper.updateCourseType(courseType);
    }

    @Override
    public CourseType getCourseType(String courseTypeId) {
        return courseTypeMapper.getCourseType(courseTypeId);
    }

    @Override
    public List<CourseType> getCourseTypeList() {
        return courseTypeMapper.getCourseTypeList();
    }
}
