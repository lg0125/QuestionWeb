package com.chris.question.user.controller;

import com.chris.question.common.utils.PageRequest;
import com.chris.question.common.utils.PageResult;
import com.chris.question.common.utils.R;
import com.chris.question.user.dto.QuestionDto;
import com.chris.question.user.feign.CourseFeignService;
import com.chris.question.user.pojo.Activity;
import com.chris.question.user.pojo.User;
import com.chris.question.user.service.ActivityService;
import com.chris.question.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("activity/service")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private UserService userService;
    @Autowired
    private CourseFeignService courseFeignService;

    //TODO
    @PostMapping("/insertion")
    public R insertActivity(@RequestBody Activity activity){
        int result = activityService.insertActivity(activity);
        return R.ok();
    }

    //TODO
    @DeleteMapping("/deleting/{activityId}")
    public R deleteActivity(@PathVariable Long activityId){
        int result = activityService.deleteActivity(activityId);
        return R.ok();
    }


    //TODO
    @SuppressWarnings("unchecked")
    @GetMapping("/getting/list/{userId}")
    public R getActivityListByUserId(@PathVariable String userId){
        User user = userService.getUser(userId);
        List<Long> activityIndexList = user.getActivityIndexList().parallelStream()
                .sorted(Comparator.comparing(Activity::getCreateDate).reversed())
                .map(Activity::getQuestionId)
                .collect(Collectors.toList());
        List<QuestionDto> activityList = (List<QuestionDto>) courseFeignService.getQuestionList(activityIndexList).get("questionList");
        return R.ok().put("activityList",activityList);
    }

    @SuppressWarnings("unchecked")
    @PostMapping("/list/page/{userId}")
    public R getActivityListPage(@PathVariable String userId,
                                 @RequestBody PageRequest pageQuery)
    {
        PageResult result = activityService.getActivityListPage(userId,pageQuery);
        List<Activity> activityList = (List<Activity>) result.getContent();
        List<Long> activityIndexList = activityList.stream()
                                        .map(Activity::getQuestionId)
                                        .collect(Collectors.toList());

        List<QuestionDto> questionList = (List<QuestionDto>) courseFeignService.getQuestionList(activityIndexList).get("questionList");
        result.setContent(questionList);
        return R.ok().put("result",result);
    }
}
