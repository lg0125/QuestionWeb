package com.chris.question.course.controller;

import com.chris.question.course.pojo.CourseType;
import com.chris.question.course.service.CourseTypeService;
import com.chris.question.common.utils.R;
import com.chris.question.course.vo.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("courseType/service")
public class CourseTypeController {

    @Autowired
    private CourseTypeService courseTypeService;

    @PostMapping("/insertion")
    public R insertCourseType(@RequestBody CourseType courseType){
        courseTypeService.insertCourseType(courseType);
        return R.ok();
    }

    @DeleteMapping("/deleting/{courseTypeId}")
    public R deleteCourseType(@PathVariable String courseTypeId){
        courseTypeService.deleteCourseType(courseTypeId);
        return R.ok();
    }

    @PutMapping("/updating")
    public R updateCourseType(@RequestBody CourseType courseType){
        courseTypeService.updateCourseType(courseType);
        return R.ok();
    }

    @GetMapping("/getting/{courseTypeId}")
    public R getCourseType(@PathVariable String courseTypeId){
        return R.ok().put("courseType",courseTypeService.getCourseType(courseTypeId));
    }

    //TODO
    @GetMapping("/list")
    public R getCourseTypeList(){
        List<CourseType> majorList = courseTypeService.getCourseTypeList();
        List<Option> majorOptions = majorList.stream()
                .map(major -> {
                    Option option = new Option();
                    option.setLabel(major.getName());
                    option.setValue(Long.parseLong(major.getId()));
                    return option;
                }).collect(Collectors.toList());
        return R.ok().put("majorOptions",majorOptions);
    }

}
