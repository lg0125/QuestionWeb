package com.chris.question.course.controller;

import com.chris.question.course.pojo.Winner;
import com.chris.question.course.service.WinnerService;
import com.chris.question.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@CrossOrigin
@RestController
@RequestMapping("winner/service")
public class WinnerController {
    @Autowired
    private WinnerService winnerService;

    @PostMapping("/insertion")
    public R insertWinner(@RequestBody Winner winner){
        int result = winnerService.insertWinner(winner);
        return R.ok();
    }

    @GetMapping("/getting/{questionId}")
    public R getWinner(@PathVariable Long questionId){
        return R.ok().put("winner",winnerService.getWinner(questionId));
    }
}
