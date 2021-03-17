package com.chris.question.course.dao;

import com.chris.question.course.pojo.CourseType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseTypeMapper {
    public int insertCourseType(CourseType courseType);
    public int deleteCourseType(String id);
    public int updateCourseType(CourseType courseType);
    public CourseType getCourseType(String id);
    public List<CourseType> getCourseTypeList();
}
