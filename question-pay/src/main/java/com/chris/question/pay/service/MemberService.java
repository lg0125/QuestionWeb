package com.chris.question.pay.service;

import com.chris.question.pay.pojo.Member;


import java.math.BigInteger;

public interface MemberService {
    public int insertMember(Member member);
    public int deleteMember(Long memberId);
    public int updateMember(Member member);
    public Member getMember(Long memberId);
}
