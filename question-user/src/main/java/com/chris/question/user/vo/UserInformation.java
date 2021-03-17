package com.chris.question.user.vo;

import com.chris.question.user.dto.CardDto;
import com.chris.question.user.dto.MemberDto;
import com.chris.question.user.pojo.Information;
import com.chris.question.user.pojo.Points;
import lombok.Data;


import java.math.BigInteger;

@Data
public class UserInformation {
    //information
    private String name;
    private String sex;
    private String city;
    private String province;
    private String work;
    //points
    private Long points;
    //member
    private String memberName;
    private String content;

    private Long priority;
    private Long addPoints;
    private Long subPoints;
    //card
    private Double money;

    public UserInformation(){}
    public UserInformation(Information information, Points points, MemberDto member, CardDto card){
        this.name= information.getName();
        this.sex=information.getSex();
        this.city=information.getCity();
        this.province=information.getProvince();
        this.work=information.getWork();

        this.points=points.getPoints();

        this.memberName=member.getName();
        this.content=member.getContent();
        this.priority=member.getPriority();
        this.addPoints=member.getAddPoints();
        this.subPoints=member.getSubPoints();

        this.money=card.getMoney();
    }
}
