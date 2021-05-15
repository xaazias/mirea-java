package ru.mirea.pr14.controllers;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import ru.mirea.pr14.Bank;
import org.springframework.web.bind.annotation.*;
import ru.mirea.pr14.BankRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class BankController {

    @Autowired
    private final BankRepository bankRepository;

    BankController(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @GetMapping("/banks")
    public List<Bank> getAllStudents() {
        return (List<Bank>) bankRepository.findAll();
    }

    @GetMapping("/banks/{id}")
    public Bank getBankByID(@PathVariable Integer id) throws NotFoundException {
        Optional optBank = bankRepository.findById(id);
        if(optBank.isPresent()) {
            return (Bank) optBank.get();
        }else {
            throw new NotFoundException("Student not found with id " + id);
        }
    }

    @PostMapping("/bank")
    Bank newEmployee(@RequestBody Bank newBank) {
        return bankRepository.save(newBank);
    }

    @DeleteMapping("/bank/{id}")
    void deleteEmployee(@PathVariable Integer id) {
        bankRepository.deleteById(id);
    }
}
