package com.chris.question.course.service.impl;

import com.chris.question.common.utils.PageRequest;
import com.chris.question.common.utils.PageResult;
import com.chris.question.common.utils.PageUtils;
import com.chris.question.course.dao.CourseMapper;
import com.chris.question.course.pojo.Course;
import com.chris.question.course.service.CourseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CourseService")
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public int insertCourse(Course course) {
        return courseMapper.insertCourse(course);
    }

    @Override
    public int deleteCourse(String courseId) {
        return courseMapper.deleteCourse(courseId);
    }

    @Override
    public int updateCourse(Course course) {
        return courseMapper.updateCourse(course);
    }

    @Override
    public Course getCourse(String courseId) {
        return courseMapper.getCourse(courseId);
    }

    @Override
    public List<Course> getCourseListByGradeId(Long gradeId) {
        return courseMapper.getCourseListByGradeId(gradeId);
    }

    @Override
    public PageResult getCourseListPageByGradeId(Long gradeId,PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest,getPageInfoByGradeId(gradeId,pageRequest));
    }

    @Override
    public List<Course> getCourseListByCourseTypeId(String courseTypeId) {
        return courseMapper.getCourseListByCourseTypeId(courseTypeId);
    }

    @Override
    public PageResult getCourseListPageByCourseTypeId(String courseTypeId,PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest,getPageInfoByCourseTypeId(courseTypeId,pageRequest));
    }

    @Override
    public List<Course> getCourseList() {
        return courseMapper.getCourseList();
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest,getPageInfo(pageRequest));
    }


    private PageInfo<Course> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Course> listByPage = courseMapper.getCourseListByPage();
        return new PageInfo<>(listByPage);
    }

    private PageInfo<Course> getPageInfoByGradeId(Long gradeId,PageRequest pageRequest){
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Course> listByPage = courseMapper.getCourseListByGradeId(gradeId);
        return new PageInfo<>(listByPage);
    }

    private PageInfo<Course> getPageInfoByCourseTypeId(String courseTypeId,PageRequest pageRequest){
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Course> listByPage = courseMapper.getCourseListByCourseTypeId(courseTypeId);
        return new PageInfo<>(listByPage);
    }
}
