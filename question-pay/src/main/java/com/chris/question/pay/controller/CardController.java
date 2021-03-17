package com.chris.question.pay.controller;

import com.chris.question.pay.pojo.Card;
import com.chris.question.pay.service.CardService;
import com.chris.question.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("card/service")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping("/insertion")
    public R insertCard(@RequestBody Card card){
        cardService.insertCard(card);
        return R.ok();
    }

    @DeleteMapping("/deleting/{cardId}")
    public R deleteCard(@PathVariable String cardId){
        cardService.deleteCard(cardId);
        return R.ok();
    }

    @PutMapping("/updating")
    public R updateCard(@RequestBody Card card){
        cardService.updateCard(card);
        return R.ok();
    }

    @GetMapping("/getting/{cardId}")
    public R getCard(@PathVariable String cardId){
        Card card= cardService.getCard(cardId);
        return R.ok().put("card",card);
    }

}
