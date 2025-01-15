package com.learning.blackjack;

import java.util.Scanner;

public class APP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        BlackjackGame game = BlackjackGame.getInstance();
        game.initializeGame(playerName);

        do {
            game.playRound();
            System.out.print("\nWould you like to play again? (Y/N) ");
        } while (scanner.nextLine().toUpperCase().equals("Y"));

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
