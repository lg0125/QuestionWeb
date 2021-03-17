package com.chris.question.course.service;

import com.chris.question.common.utils.PageRequest;
import com.chris.question.common.utils.PageResult;
import com.chris.question.course.pojo.Course;

import java.util.List;

public interface CourseService {
    public int insertCourse(Course course);
    public int deleteCourse(String courseId);
    public int updateCourse(Course course);
    public Course getCourse(String courseId);
    public List<Course> getCourseListByGradeId(Long gradeId);
    public PageResult getCourseListPageByGradeId(Long gradeId,PageRequest pageRequest);

    public List<Course> getCourseListByCourseTypeId(String courseTypeId);
    public PageResult getCourseListPageByCourseTypeId(String courseTypeId,PageRequest pageRequest);

    public List<Course> getCourseList();

    /**
     * 分页查询接口
     * 这里统一封装了分页请求和结果，避免直接引入具体框架的分页对象, 如MyBatis或JPA的分页对象
     * 从而避免因为替换ORM框架而导致服务层、控制层的分页接口也需要变动的情况，替换ORM框架也不会
     * 影响服务层以上的分页接口，起到了解耦的作用
     * @param pageRequest 自定义，统一分页查询请求
     * @return PageResult 自定义，统一分页查询结果
     */
    PageResult findPage(PageRequest pageRequest);
}
