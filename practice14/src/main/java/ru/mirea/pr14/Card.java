package ru.mirea.pr14;

import lombok.*;

@Getter
@Setter
@ToString
public class Card {
    private String cardNumber;
    private int code;

    public Card(String cardNumber, int code) {
        this.cardNumber = cardNumber;
        this.code = code;
    }
}
