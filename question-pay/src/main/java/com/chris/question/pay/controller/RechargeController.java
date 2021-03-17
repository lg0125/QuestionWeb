package com.chris.question.pay.controller;

import com.chris.question.pay.pojo.Recharge;
import com.chris.question.pay.service.RechargeService;
import com.chris.question.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@CrossOrigin
@RestController
@RequestMapping("recharge/service")
public class RechargeController {

    @Autowired
    private RechargeService rechargeService;

    @PostMapping("/insertion")
    public R insertRecharge(@RequestBody Recharge recharge){
        rechargeService.insertRecharge(recharge);
        return R.ok();
    }

    @PostMapping("/getting/{rechargeId}")
    public R getRate(@PathVariable Long rechargeId){
        Recharge recharge= rechargeService.getRecharge(rechargeId);
        return R.ok().put("recharge",recharge);
    }
}
