package com.chris.question.pay.dao;

import com.chris.question.pay.pojo.Member;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;

@Mapper
public interface MemberMapper {
    public int insertMember(Member member);
    public int deleteMember(Long id);
    public int updateMember(Member member);
    public Member getMember(Long id);
}
