package ru.mirea.pr14.controller;

import ru.mirea.pr14.Card;
import ru.mirea.pr14.CardTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {
    @Autowired
    private CardTest test;

    @PostMapping("/postCard")
    public void post(@RequestBody Card card) {
        test.add(card);
    }

    @GetMapping("/getCards")
    public List<Card> getAll() {
        return test.getGames();
    }

    @DeleteMapping("/deleteCard")
    public void delete(@RequestBody Card card) {
        test.deleteGame(card);
    }
}
