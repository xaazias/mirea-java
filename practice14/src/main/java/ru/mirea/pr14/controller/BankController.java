package ru.mirea.pr14.controller;

import ru.mirea.pr14.Bank;
import ru.mirea.pr14.BankTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankController {
    @Autowired
    private BankTest test;

    @PostMapping("/postBank")
    public void post(@RequestBody Bank bank) {
        test.add(bank);
    }

    @GetMapping("/getBanks")
    public List<Bank> getAll() {
        return test.getAll();
    }

    @DeleteMapping("/deleteBank")
    public void delete(@RequestBody Bank bank) {
        test.delete(bank);
    }
}
