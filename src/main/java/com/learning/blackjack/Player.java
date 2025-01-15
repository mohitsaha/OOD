package com.learning.blackjack;

public abstract class Player {
    protected String name;
    protected Hand hand;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    public abstract boolean wantsToHit(Card dealerUpCard);

    public void addCard(Card card) {
        hand.addCard(card);
    }

    public int getScore() {
        return hand.calculateScore();
    }

    public void clearHand() {
        hand.clear();
    }

    public Hand getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }
}