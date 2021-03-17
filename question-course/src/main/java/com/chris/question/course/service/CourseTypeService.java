package com.chris.question.course.service;

import com.chris.question.course.pojo.CourseType;

import java.util.List;

public interface CourseTypeService {
    public int insertCourseType(CourseType courseType);
    public int deleteCourseType(String courseTypeId);
    public int updateCourseType(CourseType courseType);
    public CourseType getCourseType(String courseTypeId);
    public List<CourseType> getCourseTypeList();
}
