package com.chris.question.user.controller;

import com.chris.question.common.utils.PageRequest;
import com.chris.question.common.utils.PageResult;
import com.chris.question.common.utils.R;
import com.chris.question.user.dto.IndexDto;
import com.chris.question.user.dto.QuestionDto;
import com.chris.question.user.feign.CourseFeignService;
import com.chris.question.user.pojo.Forward;
import com.chris.question.user.pojo.User;
import com.chris.question.user.service.ForwardService;
import com.chris.question.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("forward/service")
public class ForwardController {

    @Autowired
    private ForwardService forwardService;

    @Autowired
    private UserService userService;
    @Autowired
    private CourseFeignService courseFeignService;

    //TODO
    @PostMapping("/insertion")
    public int insertForward(@RequestBody Forward forward){return forwardService.insertForward(forward);}

    //TODO
    @DeleteMapping("/deleting/{forwardId}")
    public int deleteForward(@PathVariable Long forwardId){return forwardService.deleteForward(forwardId);}

    @GetMapping("/getting/{forwardId}")
    public Forward getForward(@PathVariable Long forwardId){return forwardService.getForward(forwardId);}

    //TODO
    @SuppressWarnings("unchecked")
    @GetMapping("/getting/list/{userId}")
    public R getForwardListByUserId(@PathVariable String userId){
        User user = userService.getUser(userId);

        List<Long> forwardIndexList = user.getForwardIndexList().parallelStream()
                .sorted(Comparator.comparing(Forward::getCreateDate).reversed())
                .map(Forward::getQuestionId)
                .collect(Collectors.toList());
        List<QuestionDto> forwardList = (List<QuestionDto>) courseFeignService.getQuestionList(forwardIndexList).get("questionList");

        return R.ok().put("forwardList",forwardList);
    }

    @SuppressWarnings("unchecked")
    @PostMapping("/list/page/{userId}")
    public R getForwardListPage(@PathVariable String userId,
                                @RequestBody PageRequest pageRequest)
    {
        PageResult result = forwardService.getForwardListPage(userId, pageRequest);
        List<Forward> forwardList = (List<Forward>)  result.getContent();
        List<Long> forwardIndexList = forwardList.stream()
                                        .map(Forward::getQuestionId)
                                        .collect(Collectors.toList());

        List<QuestionDto> list = (List<QuestionDto>) courseFeignService.getQuestionList(forwardIndexList).get("questionList");
        result.setContent(list);
        return  R.ok().put("result",result);
    }

    @DeleteMapping("/del/{userId}/{questionId}")
    public R deleteForwardByIndex(@PathVariable String userId,@PathVariable Long questionId){
        IndexDto indexDto = new IndexDto(userId,questionId);
        return R.ok().put("result",forwardService.deleteForwardByIndex(indexDto));
    }
}
