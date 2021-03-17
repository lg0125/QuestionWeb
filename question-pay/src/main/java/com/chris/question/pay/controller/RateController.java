package com.chris.question.pay.controller;

import com.chris.question.pay.pojo.Rate;
import com.chris.question.pay.service.RateService;
import com.chris.question.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@CrossOrigin
@RestController
@RequestMapping("rate/service")
public class RateController {

    @Autowired
    private RateService rateService;

    @PostMapping("/insertion")
    public R insertRate(@RequestBody Rate rate){
        int result =rateService.insertRate(rate);
        return R.ok();
    }

    @DeleteMapping("/deleting/{memberId}")
    public R deleteRate(@PathVariable Long memberId){
        int result =rateService.deleteRate(memberId);
        return R.ok();
    }

    @PutMapping("/updating")
    public R updateRate(@RequestBody Rate rate){
        int result =rateService.updateRate(rate);
        return R.ok();
    }

    @GetMapping("/getting/{memberId}")
    public R getRate(@PathVariable Long memberId){
        return R.ok().put("rate",rateService.getRate(memberId));
    }

}
