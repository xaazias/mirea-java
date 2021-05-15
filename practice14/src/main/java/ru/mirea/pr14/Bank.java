package ru.mirea.pr14;

import lombok.*;

@Getter
@Setter
@ToString
public class Bank {
    private String name;
    private String address;

    public Bank(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
