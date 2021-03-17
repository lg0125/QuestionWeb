package com.chris.question.pay.service.impl;

import com.chris.question.pay.dao.MemberMapper;
import com.chris.question.pay.pojo.Member;
import com.chris.question.pay.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service("MemberService")
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public int insertMember(Member member) {
        return memberMapper.insertMember(member);
    }

    @Override
    public int deleteMember(Long memberId) {
        return memberMapper.deleteMember(memberId);
    }

    @Override
    public int updateMember(Member member) {
        return memberMapper.updateMember(member);
    }

    @Override
    public Member getMember(Long memberId) {
        return memberMapper.getMember(memberId);
    }
}
