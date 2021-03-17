package com.chris.question.pay.service.impl;

import com.chris.question.pay.dao.CardMapper;
import com.chris.question.pay.pojo.Card;
import com.chris.question.pay.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CardService")
public class CardServiceImpl implements CardService {

    @Autowired
    private CardMapper cardMapper;

    @Override
    public void insertCard(Card card) {
        cardMapper.insertCard(card);
    }

    @Override
    public void deleteCard(String cardId) {
        cardMapper.deleteCard(cardId);
    }

    @Override
    public void updateCard(Card card) {
        cardMapper.updateCard(card);
    }

    @Override
    public Card getCard(String cardId) {
        return cardMapper.getCard(cardId);
    }
}
