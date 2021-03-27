package com.chris.question.user.controller;


import com.chris.question.common.utils.R;

import com.chris.question.user.dto.MemberDto;
import com.chris.question.user.dto.QuestionDto;
import com.chris.question.user.dto.UserDto;
import com.chris.question.user.feign.CourseFeignService;
import com.chris.question.user.feign.PayFeignService;
import com.chris.question.user.pojo.*;
import com.chris.question.user.service.BlogService;
import com.chris.question.user.service.InformationService;
import com.chris.question.user.service.PointsService;
import com.chris.question.user.service.UserService;

import com.chris.question.user.vo.UserTrace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("question/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private InformationService informationService;
    @Autowired
    private PointsService pointsService;
    @Autowired
    private BlogService blogService;

    @Autowired
    private PayFeignService payFeignService;
    @Autowired
    private CourseFeignService courseFeignService;


    /**
     * UserInformation
     *
     *
     * */
    //TODO
    @GetMapping("/information/{userId}")
    public R getUserInformation(@PathVariable String userId){
        Information information = informationService.getInformation(userId);
        return R.ok().put("userInfo",information);
    }

    //TODO
    @SuppressWarnings("unchecked")
    @GetMapping("/trace/{userId}")
    public R getUserTrace(@PathVariable String userId){
        User user = userService.getUser(userId);

        List<Blog> blogList = blogService.getBlogListByUserId(userId);

        List<Long> activityIndexList = user.getActivityIndexList().parallelStream()
                                        .sorted(Comparator.comparing(Activity::getCreateDate).reversed())
                                        .limit(5)
                                        .map(Activity::getQuestionId)
                                        .collect(Collectors.toList());
        List<QuestionDto> activityList = (List<QuestionDto>) courseFeignService.getQuestionList(activityIndexList).get("questionList");


        List<Long> collectIndexList = user.getCollectIndexList().parallelStream()
                                        .sorted(Comparator.comparing(Collect::getCreateDate).reversed())
                                        .limit(5)
                                        .map(Collect::getQuestionId)
                                        .collect(Collectors.toList());
        List<QuestionDto> collectList = (List<QuestionDto>) courseFeignService.getQuestionList(collectIndexList).get("questionList");

        List<Long> forwardIndexList = user.getForwardIndexList().parallelStream()
                                    .sorted(Comparator.comparing(Forward::getCreateDate).reversed())
                                    .limit(5)
                                    .map(Forward::getQuestionId)
                                    .collect(Collectors.toList());
        List<QuestionDto> forwardList = (List<QuestionDto>) courseFeignService.getQuestionList(forwardIndexList).get("questionList");

        UserTrace userTrace = new UserTrace(blogList,activityList,collectList,forwardList);

        return R.ok().put("userTrace",userTrace);
    }

    //TODO
    @PostMapping("/login")
    public R login(@RequestBody UserDto user) {
        String id = user.getId();
        String password = user.getPassword();
        User login = userService.getUser(id);
        if(login.getPassword().equals(password)){
            return R.ok().put("result","success");
        }else{
            return R.ok().put("result","error");
        }
    }

    //TODO
    @PostMapping("/signup")
    public R signUp(@RequestBody UserDto user){
        try{
            userService.insertUser(user);
            return R.ok().put("result","success");
        }catch (Exception e){
            return R.ok().put("result","error");
        }
    }


    //TODO
    @GetMapping("/info/{userId}")
    public R getInfo(@PathVariable String userId){
        Information info = informationService.getInformation(userId);
        return R.ok().put("info",info);
    }

    //TODO
    @GetMapping("/points/{userId}")
    public R getPoints(@PathVariable String userId){
        Points points = pointsService.getPoints(userId);
        return R.ok().put("points",points);
    }

    //TODO
    @SuppressWarnings("unchecked")
    @GetMapping("/member/{userId}")
    public R getMember(@PathVariable String userId){
        User user = userService.getUser(userId);
        List<MemberDto> member = (List<MemberDto>) payFeignService.getMember(user.getMemberId()).get("member");
        return R.ok().put("member",member.get(0));
    }

    @SuppressWarnings("unchecked")
    @PostMapping("/collect/{userId}")
    public R getCollectListPage(@PathVariable String userId)
    {
        User user = userService.getUser(userId);

        List<Long> collectIndexList = user.getCollectIndexList().parallelStream()
                .sorted(Comparator.comparing(Collect::getCreateDate).reversed())
                .map(Collect::getQuestionId)
                .collect(Collectors.toList());
        List<QuestionDto> collectList = (List<QuestionDto>) courseFeignService.getQuestionList(collectIndexList).get("questionList");



        return R.ok().put("collectList",collectList);
    }

    @SuppressWarnings("unchecked")
    @PostMapping("/forward/{userId}")
    public R getForwardListPage(@PathVariable String userId)
    {
        User user = userService.getUser(userId);

        List<Long> forwardIndexList = user.getForwardIndexList().parallelStream()
                .sorted(Comparator.comparing(Forward::getCreateDate).reversed())
                .limit(5)
                .map(Forward::getQuestionId)
                .collect(Collectors.toList());
        List<QuestionDto> forwardList = (List<QuestionDto>) courseFeignService.getQuestionList(forwardIndexList).get("questionList");

        return R.ok().put("forwardList",forwardList);

    }


}
