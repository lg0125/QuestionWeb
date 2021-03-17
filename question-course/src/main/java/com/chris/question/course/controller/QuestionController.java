package com.chris.question.course.controller;

import com.chris.question.common.utils.PageRequest;
import com.chris.question.common.utils.R;
import com.chris.question.course.pojo.Comment;
import com.chris.question.course.pojo.Course;
import com.chris.question.course.pojo.Grade;
import com.chris.question.course.pojo.Question;
import com.chris.question.course.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


@CrossOrigin
@RestController
@RequestMapping("question/service")
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private SchoolService schoolService;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private CommentService commentService;

    @PostMapping("/insertion")
    public R insertQuestion(@RequestBody Question question){
        int result = questionService.insertQuestion(question);
        return R.ok();
    }

    @DeleteMapping("/deleting/{questionId}")
    public R deleteQuestion(@PathVariable Long questionId){
        int result = questionService.deleteQuestion(questionId);
        return R.ok();
    }

    @PutMapping("/updating")
    public R updateQuestion(@RequestBody Question question){
        int result = questionService.updateQuestion(question);
        return R.ok();
    }

    //TODO
    @GetMapping("/getting/{questionId}")
    public R getQuestion(@PathVariable Long questionId){
        Question question = questionService.getQuestion(questionId);
        return R.ok().put("question",question);
    }

    @GetMapping("/getting/school/{schoolId}")
    public R getQuestionListBySchoolId(@PathVariable Long schoolId){
        List<Grade> gradeList = gradeService.getGradeListBySchoolId(schoolId);
        List<Course> courseList = gradeList.stream()
                                    .map(grade ->
                                        courseService.getCourseListByGradeId(grade.getId())
                                    ).flatMap(Collection::stream).collect(Collectors.toList());
        List<Question> questionList = courseList.stream()
                                        .map(course -> questionService.getQuestionListByCourseId(course.getId()))
                                        .flatMap(Collection::stream).collect(Collectors.toList());
        return R.ok().put("questionList",questionList);
    }

    @GetMapping("/getting/grade/{gradeId}")
    public R getQuestionByGradeId(@PathVariable Long gradeId){
        List<Course> courseList = courseService.getCourseListByGradeId(gradeId);
        List<Question> questionList = courseList.stream()
                                        .map(course -> questionService.getQuestionListByCourseId(course.getId()))
                                        .flatMap(Collection::stream).collect(Collectors.toList());

        return R.ok().put("questionList",questionList);
    }

    @GetMapping("/getting/courseType/{courseTypeId}")
    public R getQuestionByCourseTypeId(@PathVariable String courseTypeId){
        List<Course> courseList = courseService.getCourseListByCourseTypeId(courseTypeId);
        List<Question> questionList = courseList.stream()
                                        .map(course -> questionService.getQuestionListByCourseId(courseTypeId))
                                        .flatMap(Collection::stream).collect(Collectors.toList());
        return R.ok().put("questionList",questionList);
    }

    //TODO
    @GetMapping("/getting/course/{courseId}")
    public R getQuestionByCourseId(@PathVariable String courseId){
        List<Question> questionList = questionService.getQuestionListByCourseId(courseId).stream()
                                        .sorted(Comparator.comparing(Question::getCreateDate).reversed())
                                        .collect(Collectors.toList());
        return R.ok().put("questionList",questionList);
    }

    //TODO
    @PostMapping("/getting/course/page/{courseId}")
    public R getQuestionListPageByCourseId(@PathVariable String courseId,
                                           @RequestBody PageRequest pageQuery)
    {
        return R.ok().put("result",questionService.getQuestionListPageByCourseId(courseId,pageQuery));
    }

    //TODO feign
    @PostMapping("/list")
    public R getQuestionList(@RequestBody List<Long> questionIdList){
        Function<Long,Question> function = questionId -> questionService.getQuestion(questionId);

        List<Question> questionList = questionIdList.stream()
                                        .map(function)
                                        .collect(Collectors.toList());

        return R.ok().put("questionList",questionList);
    }

}
