package ru.mirea.pr14.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import ru.mirea.pr14.Bank;
import org.springframework.web.bind.annotation.*;
import ru.mirea.pr14.BankRepository;

import java.util.List;

@RestController
public class BankController {

    @Autowired
    private final BankRepository repository;

    BankController(BankRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/bank")
    Bank newEmployee(@RequestBody Bank newBank) {
        return repository.save(newBank);
    }

    @GetMapping("/banks")
    List<Bank> all() {
        return (List<Bank>) repository.findAll();
    }

    @DeleteMapping("/bank/{id}")
    void deleteEmployee(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
