package ru.mirea.pr14.controllers;

import ru.mirea.pr14.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mirea.pr14.CardRepository;

import java.util.List;

@RestController
public class CardController {

    @Autowired
    private final CardRepository repository;

    CardController(CardRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/card")
    Card newCard(@RequestBody Card newCard) {
        return repository.save(newCard);
    }

    @GetMapping("/cards")
    List<Card> all() {
        return (List<Card>) repository.findAll();
    }

    @DeleteMapping("/card/{id}")
    void deleteEmployee(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
