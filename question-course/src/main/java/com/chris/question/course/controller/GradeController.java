package com.chris.question.course.controller;

import com.chris.question.course.pojo.Grade;
import com.chris.question.course.service.GradeService;
import com.chris.question.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@CrossOrigin
@RestController
@RequestMapping("grade/service")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @PostMapping("/insertion")
    public R insertGrade(@RequestBody Grade grade){
        int result = gradeService.insertGrade(grade);
        return R.ok();
    }

    @DeleteMapping("/deleting/{gradeId}")
    public R deleteGrade(@PathVariable Long gradeId){
        int result = gradeService.deleteGrade(gradeId);
        return R.ok();
    }

    @PutMapping("/updating")
    public R updateGrade(@RequestBody Grade grade){
        int result = gradeService.updateGrade(grade);
        return R.ok();
    }

    @GetMapping("/getting/{gradeId}")
    public R getGrade(@PathVariable Long gradeId){
        return R.ok().put("grade",gradeService.getGrade(gradeId));
    }

    //TODO
    @GetMapping("/list")
    public R getGradeList(){
        return R.ok().put("gradeList",gradeService.getGradeList());
    }

}
