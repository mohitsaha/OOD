package com.learning.blackjack;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner scanner;

    public HumanPlayer(String name) {
        super(name);
        scanner = new Scanner(System.in);
    }

    @Override
    public boolean wantsToHit(Card dealerUpCard) {
        System.out.println("\nYour hand: " + hand.getCards());
        System.out.println("Your score: " + getScore());
        System.out.println("Dealer's up card: " + dealerUpCard);

        while (true) {
            System.out.print("Would you like to (H)it or (S)tand? ");
            String input = scanner.nextLine().toUpperCase();
            if (input.equals("H")) return true;
            if (input.equals("S")) return false;
            System.out.println("Invalid input. Please enter H or S.");
        }
    }
}