package ru.mirea.pr14.controllers;

import javassist.NotFoundException;
import ru.mirea.pr14.BankRepository;
import ru.mirea.pr14.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mirea.pr14.CardRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CardController {

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private CardRepository cardRepository;

    CardController(CardRepository repository) {
        this.cardRepository = repository;
    }

    @GetMapping("/banks/{bankId}/cards")
    public List<Card> getContactByStudentId(@PathVariable Integer bankId) {
        return cardRepository.findByBankId(bankId);
    }

    @PostMapping("/banks/{bankId}/cards")
    public Card addCard(@PathVariable Integer bankId,
                                    @Valid @RequestBody Card card) throws NotFoundException {
        return bankRepository.findById(bankId)
                .map(bank -> {
                    card.setBank(bank);
                    return cardRepository.save(card);
                }).orElseThrow(() -> new NotFoundException("Student not found!"));
    }

    @DeleteMapping("/card/{id}")
    void deleteEmployee(@PathVariable Integer id) {
        cardRepository.deleteById(id);
    }
}
