package com.chris.question.pay.controller;

import com.chris.question.common.utils.R;
import com.chris.question.pay.pojo.Member;
import com.chris.question.pay.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

@CrossOrigin
@RestController
@RequestMapping("member/service")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private ThreadPoolExecutor executor;

    @PostMapping("/insertion")
    public R insertMember(@RequestBody Member member){
        int result =memberService.insertMember(member);
        return R.ok();
    }

    @DeleteMapping("/deleting/{memberId}")
    public R deleteMember(@PathVariable Long memberId){
        int result =memberService.deleteMember(memberId);
        return R.ok();
    }

    @PutMapping("/updating")
    public R updateMember(@RequestBody Member member){
        int result=memberService.updateMember(member);
        return R.ok();
    }

    //TODO
    @GetMapping("/getting/{memberId}")
    public R getMember(@PathVariable Long memberId) {
        Member member = memberService.getMember(memberId);
        List<Member> list = new ArrayList<>();
        list.add(member);
        return R.ok().put("member",list);
    }
}
