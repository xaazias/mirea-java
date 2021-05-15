package ru.mirea.pr14;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardTest {
    private List<Card> cards;

    public CardTest() {
        cards = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        cards.add(new Card("5678 1234 1234 5678", 1234));
        cards.add(new Card("5678 5678 1234 5678", 4321));
        cards.add(new Card("1234 1234 1234 5678", 1337));
    }

    public void add(Card card) {
        cards.add(card);
    }

    public List<Card> getGames() {
        return cards;
    }

    public void deleteGame(Card card) {
        cards.remove(card);
    }
}
