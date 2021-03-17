package com.chris.question.pay.dao;

import com.chris.question.pay.pojo.Card;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CardMapper {
    public void insertCard(Card card);
    public void deleteCard(String id);
    public void updateCard(Card card);
    public Card getCard(String id);
}
