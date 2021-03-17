package com.chris.question.user.controller;

import com.chris.question.common.utils.R;
import com.chris.question.user.pojo.Points;
import com.chris.question.user.service.PointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@CrossOrigin
@RestController
@RequestMapping("points/service")
public class PointsController {

    @Autowired
    private PointsService pointsService;

    @PostMapping("/insertion")
    public R insertPoints(@RequestBody Points points){
        int result =  pointsService.insertPoints(points);
        return R.ok();
    }

    @DeleteMapping("/deletion/{userId}")
    public R deletePoints(@PathVariable String userId){
        int result =  pointsService.deletePoints(userId);
        return R.ok();
    }

    @PutMapping("/updating")
    public R updatePoints(@RequestBody Points points){
        int result = pointsService.updatePoints(points);
        return R.ok();
    }

    //TODO
    @GetMapping("/getting/{userId}")
    public R getPoints(@PathVariable String userId){return R.ok().put("points",pointsService.getPoints(userId));}

}
