package com.chris.question.course.controller;

import com.chris.question.common.utils.PageRequest;
import com.chris.question.course.pojo.Course;
import com.chris.question.course.service.CourseService;
import com.chris.question.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("course/service")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/insertion")
    public R insertCourse(@RequestBody Course course){
        int result = courseService.insertCourse(course);
        return R.ok();
    }

    @DeleteMapping("/deleting/{courseId}")
    public R deleteCourse(@PathVariable String courseId){
        int result = courseService.deleteCourse(courseId);
        return R.ok();
    }

    @PutMapping("/updating")
    public R updateCourse(@RequestBody Course course){
        int result = courseService.updateCourse(course);
        return R.ok();
    }

    @GetMapping("/getting/{courseId}")
    public R getCourse(@PathVariable String courseId){
        return R.ok().put("course",courseService.getCourse(courseId));
    }


    //TODO
    @GetMapping("/getting/list/grade/{gradeId}")
    public R getCourseListByGradeId(@PathVariable Long gradeId){
        return R.ok().put("courseListByGrade",courseService.getCourseListByGradeId(gradeId));
    }

    //TODO
    @PostMapping("/getting/list/grade/page/{gradeId}")
    public R getCourseListPageByGradeId(@PathVariable Long gradeId,
                                        @RequestBody PageRequest pageQuery)
    {
        return R.ok().put("result",courseService.getCourseListPageByGradeId(gradeId,pageQuery));
    }

    //TODO
    @GetMapping("/getting/list/major/{courseTypeId}")
    public R getCourseListByCourseType(@PathVariable String courseTypeId){
        return R.ok().put("courseListByMajor",courseService.getCourseListByCourseTypeId(courseTypeId));
    }

    //TODO
    @PostMapping("/getting/list/major/page/{courseTypeId}")
    public R getCourseListPageByCourseType(@PathVariable String courseTypeId,
                                           @RequestBody PageRequest pageQuery)
    {
        return R.ok().put("result",courseService.getCourseListPageByCourseTypeId(courseTypeId,pageQuery));
    }

    //TODO
    @GetMapping("/list")
    public R getCourseList(){
        List<Course> courseList = courseService.getCourseList().stream()
                                    .limit(10)
                                    .collect(Collectors.toList());
        return R.ok().put("courseList",courseList);

    }

    @PostMapping("/page/list")
    public R getCourseListByPage(@RequestBody PageRequest pageQuery){
        return R.ok().put("result",courseService.findPage(pageQuery));
    }
}
