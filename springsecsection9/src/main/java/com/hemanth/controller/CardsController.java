package com.hemanth.controller;

import com.hemanth.model.Cards;
import com.hemanth.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {
    @Autowired
    private CardsRepository cuCardsRepository;
    @GetMapping("/myCards")
    public List<Cards> controller(@RequestParam int id){

        List<Cards> cards=cuCardsRepository.findByCustomerId(id);
        if(cards!=null)
            return cards;
        return null;
    }
}
