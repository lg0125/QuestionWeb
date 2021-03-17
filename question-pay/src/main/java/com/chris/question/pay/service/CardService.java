package com.chris.question.pay.service;

import com.chris.question.pay.pojo.Card;

public interface CardService {
    public void insertCard(Card card);
    public void deleteCard(String cardId);
    public void updateCard(Card card);
    public Card getCard(String cardId);
}
