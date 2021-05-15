package ru.mirea.pr14;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankTest {
    private List<Bank> banks;

    public BankTest() {
        banks = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        banks.add(new Bank("Sberbank", "Street, 1"));
        banks.add(new Bank("Tinkoff", "Street, 2"));
        banks.add(new Bank("AlphaBank", "Street, 3"));
    }
    public void add(Bank bank) {
        banks.add(bank);
    }


    public List<Bank> getAll() {
        return banks;
    }


    public void delete(Bank bank) {
        banks.remove(bank);
    }
}
