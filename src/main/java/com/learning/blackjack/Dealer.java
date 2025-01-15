package com.learning.blackjack;

public class Dealer extends Player {
    private static final int DEALER_STAND_THRESHOLD = 17;

    public Dealer() {
        super("Dealer");
    }

    @Override
    public boolean wantsToHit(Card dealerUpCard) {
        return getScore() < DEALER_STAND_THRESHOLD;
    }
}