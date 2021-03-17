package com.chris.question.course.dao;

import com.chris.question.course.pojo.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {
    public int insertCourse(Course course);
    public int deleteCourse(String id);
    public int updateCourse(Course course);
    public Course getCourse(String id);
    public List<Course> getCourseListByGradeId(Long gradeId);
    public List<Course> getCourseListByCourseTypeId(String courseTypeId);
    public List<Course> getCourseList();
    public List<Course> getCourseListByPage();
 }
