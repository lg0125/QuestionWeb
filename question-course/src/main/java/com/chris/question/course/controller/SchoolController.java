package com.chris.question.course.controller;

import com.chris.question.course.pojo.Grade;
import com.chris.question.course.pojo.School;
import com.chris.question.course.service.SchoolService;
import com.chris.question.common.utils.R;
import com.chris.question.course.vo.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

import static java.util.stream.Collectors.toList;

@CrossOrigin
@RestController
@RequestMapping("school/service")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @PostMapping("/insertion")
    public R insertSchool(@RequestBody School school){
        int result = schoolService.insertSchool(school);
        return R.ok();
    }

    @DeleteMapping("/deleting/{schoolId}")
    public R deleteSchool(@PathVariable Long schoolId){
        int result = schoolService.deleteSchool(schoolId);
        return R.ok();
    }

    @PutMapping("/updating")
    public R updateSchool(@RequestBody School school){
        int result = schoolService.updateSchool(school);
        return R.ok();
    }

    @GetMapping("/getting/{schoolId}")
    public R getSchool(@PathVariable Long schoolId){
        return R.ok().put("School",schoolService.getSchool(schoolId));
    }

    //TODO
    @GetMapping("/list")
    public R getSchoolList(){
        List<School> schoolList = schoolService.getSchoolList();
        List<Option> options = schoolList.stream()
                            .map( school -> {
                                Option option = new Option();
                                option.setLabel(school.getName());
                                option.setValue(school.getId());
                                List<Grade> gradeList = school.getGradeList();
                                List<Option> children = gradeList.stream()
                                                            .map(grade -> {
                                                                Option childOption = new Option();
                                                                childOption.setLabel(grade.getContent());
                                                                childOption.setValue(grade.getId());
                                                                return childOption;
                                                            }).collect(toList());
                                option.setChildren(children);
                                return option;
                            }).collect(toList());
        return R.ok().put("schoolOptions",options);
    }

}
