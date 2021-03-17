package com.chris.question.user.controller;

import com.chris.question.common.utils.PageRequest;
import com.chris.question.common.utils.PageResult;
import com.chris.question.common.utils.R;
import com.chris.question.user.dto.QuestionDto;
import com.chris.question.user.feign.CourseFeignService;
import com.chris.question.user.pojo.Activity;
import com.chris.question.user.pojo.Collect;
import com.chris.question.user.pojo.User;
import com.chris.question.user.service.CollectService;
import com.chris.question.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("collect/service")
public class CollectController {

    @Autowired
    private CollectService collectService;

    @Autowired
    private UserService userService;
    @Autowired
    private CourseFeignService courseFeignService;

    //TODO
    @PostMapping("/insertion")
    public R insertCollect(@RequestBody Collect collect){
        int result = collectService.insertCollect(collect);
        return  R.ok();
    }

    //TODO
    @DeleteMapping("/deleting/{collectId}")
    public R deleteCollect(@PathVariable Long collectId){
        int result =  collectService.deleteCollect(collectId);
        return  R.ok();
    }

    @GetMapping("/getting/{collectId}")
    public R getCollect(@PathVariable Long collectId){

        return R.ok().put("collect",collectService.getCollect(collectId));
    }

    //TODO
    @SuppressWarnings("unchecked")
    @GetMapping("/getting/list/{userId}")
    public R getCollectListByUserId(@PathVariable String userId){

        User user = userService.getUser(userId);

        List<Long> collectIndexList = user.getCollectIndexList().parallelStream()
                                            .sorted(Comparator.comparing(Collect::getCreateDate))
                                            .map(Collect::getQuestionId)
                                            .collect(Collectors.toList());
        List<QuestionDto> collectList = (List<QuestionDto>) courseFeignService.getQuestionList(collectIndexList).get("questionList");

        return R.ok().put("collectList",collectList);
    }

    @SuppressWarnings("unchecked")
    @PostMapping("/list/page/{userId}")
    public R getCollectListPage(@PathVariable String userId,
                                @RequestBody PageRequest pageQuery)
    {
        PageResult result = collectService.getCollectListPageByUserId(userId,pageQuery);
        List<Collect> collectList = (List<Collect>) result.getContent();
        List<Long> collectIndexList = collectList.stream()
                                        .map(Collect::getQuestionId)
                                        .collect(Collectors.toList());

        List<QuestionDto> list = (List<QuestionDto>) courseFeignService.getQuestionList(collectIndexList).get("questionList");
        result.setContent(list);
        return R.ok().put("result",result);
    }

}
