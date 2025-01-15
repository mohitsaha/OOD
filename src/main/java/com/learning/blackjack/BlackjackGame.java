package com.learning.blackjack;

public class BlackjackGame {
    private static BlackjackGame instance;
    private Deck deck;
    private Player player;
    private Dealer dealer;
    private GameState state;

    private BlackjackGame() {
        deck = new Deck();
        dealer = new Dealer();
        state = GameState.PLAYER_TURN;
    }

    public static BlackjackGame getInstance() {
        if (instance == null) {
            instance = new BlackjackGame();
        }
        return instance;
    }

    public void initializeGame(String playerName) {
        player = new HumanPlayer(playerName);
    }

    public void playRound() {
        // Initial deal
        dealer.clearHand();
        player.clearHand();

        // Deal two cards to each player
        for (int i = 0; i < 2; i++) {
            player.addCard(deck.drawCard());
            dealer.addCard(deck.drawCard());
        }

        // Player's turn
        while (player.getScore() <= 21 && player.wantsToHit(dealer.getHand().getCards().get(0))) {
            player.addCard(deck.drawCard());
        }

        // Dealer's turn if player hasn't busted
        if (player.getScore() <= 21) {
            System.out.println("\nDealer's turn:");
            System.out.println("Dealer's hand: " + dealer.getHand().getCards());

            while (dealer.wantsToHit(null)) {
                Card card = deck.drawCard();
                dealer.addCard(card);
                System.out.println("Dealer draws: " + card);
            }
        }

        // Determine winner
        determineWinner();
    }

    private void determineWinner() {
        int playerScore = player.getScore();
        int dealerScore = dealer.getScore();

        System.out.println("\nGame Over!");
        System.out.println("Your final hand: " + player.getHand().getCards());
        System.out.println("Your final score: " + playerScore);
        System.out.println("Dealer's final hand: " + dealer.getHand().getCards());
        System.out.println("Dealer's final score: " + dealerScore);

        if (playerScore > 21) {
            System.out.println("You bust! Dealer wins!");
        } else if (dealerScore > 21) {
            System.out.println("Dealer busts! You win!");
        } else if (playerScore > dealerScore) {
            System.out.println("You win!");
        } else if (dealerScore > playerScore) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}