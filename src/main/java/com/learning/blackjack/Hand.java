package com.learning.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }

    public int calculateScore() {
        int score = 0;
        int numAces = 0;

        for (Card card : cards) {
            if (card.getValue() == 11) { // Ace
                numAces++;
            }
            score += card.getValue();
        }

        // Adjust for aces if needed
        while (score > 21 && numAces > 0) {
            score -= 10; // Convert ace from 11 to 1
            numAces--;
        }

        return score;
    }

    public void clear() {
        cards.clear();
    }
}
