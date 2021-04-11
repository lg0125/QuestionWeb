package com.chris.question.user.controller;

import com.chris.question.common.utils.R;
import com.chris.question.user.pojo.Information;
import com.chris.question.user.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@CrossOrigin
@RestController
@RequestMapping("information/service")
public class InformationController {

    @Autowired
    private InformationService informationService;

    @PostMapping("/insertion")
    public R insertInformation(@RequestBody Information information){
        int result = informationService.insertInformation(information);
        return R.ok();
    }

    @DeleteMapping("/deleting/{userId}")
    public R deleteInformation(@PathVariable String userId){
         int result = informationService.deleteInformation(userId);
         return R.ok();
    }

    @PutMapping("/updating")
    public R updateInformation(@RequestBody Information information){
        int result = informationService.updateInformation(information);
        return R.ok();
    }

    @GetMapping("/getting/{userId}")
    public R getInformation(@PathVariable String userId){return R.ok().put("userInfo",informationService.getInformation(userId));}

}
