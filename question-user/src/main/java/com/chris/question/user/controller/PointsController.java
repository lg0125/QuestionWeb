package com.chris.question.user.controller;

import com.chris.question.common.utils.R;
import com.chris.question.user.dto.PointsDto;
import com.chris.question.user.pojo.Points;
import com.chris.question.user.service.PointsService;
import com.chris.question.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@CrossOrigin
@RestController
@RequestMapping("points/service")
public class PointsController {

    @Autowired
    private PointsService pointsService;
    @Autowired
    private UserService userService;

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
    public R updatePoints(@RequestBody PointsDto points){
        String userId = points.getUserId();
        Long point = points.getPoints();
        String type = points.getType();
        Points userPoints = pointsService.getPoints(userId);

        if(type.equals("add")){
            userPoints.setPoints(userPoints.getPoints()+point);
        }else{
            userPoints.setPoints(userPoints.getPoints()-point);
        }

        pointsService.updatePoints(userPoints);

        return R.ok();
    }

    //TODO
    @GetMapping("/getting/{userId}")
    public R getPoints(@PathVariable String userId){return R.ok().put("points",pointsService.getPoints(userId));}

}
