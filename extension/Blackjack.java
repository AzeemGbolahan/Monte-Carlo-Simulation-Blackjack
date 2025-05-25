/**
 * Author: Azeem Gbolahan
 * 
 * File: Blackjack.java
 * 
 * Description:
 * This class simulates a console-based version of the classic card game Blackjack,
 * where a player competes against a dealer. The game follows basic Blackjack rules:
 * 
 * - Both the player and dealer are dealt two cards.
 * - The player chooses to "hit" (draw another card) or "stand" (end their turn).
 * - The dealer automatically draws until reaching a hand value of 17 or more.
 * - If either party exceeds 21, they "bust" and lose the round.
 * 
 * Key Components:
 * - `Deck` class handles card creation, shuffling, and dealing.
 * - `Hand` class manages card collections and calculates hand totals.
 * - This class (`Blackjack`) coordinates game setup, turns, outcomes, and displays.
 * 
 * Features:
 * - Supports standard simulation of Blackjack (via `game()` method)
 * - Supports an interactive console version where users input "hit" or "stand"
 * - Includes logic for player and dealer turns, bust checking, and scoring
 * 
 * Educational Purpose:
 * This project demonstrates object-oriented programming, control structures,
 * user interaction via Scanner, basic randomness with Monte Carlo simulation,
 * and decision-making logic in Java.
 */

import java.util.Scanner;

 public class Blackjack {

    // These three lines create the core components of the game:
    Deck deck = new Deck();         // The full 52-card deck that will be used
    Hand player = new Hand();       // The player's hand (list of cards)
    Hand dealer = new Hand();       // The dealer's hand (another list of cards)
    Scanner scanner = new Scanner(System.in); // A new scanner to receive player's input from the command line

    /**
     * Main method — where the game begins.
     * It creates a Blackjack game object, deals the cards, handles turns, and prints the results.
     */
    public static void main(String[] args) {
        Blackjack game = new Blackjack();  // Create a new game instance

        game.reset();  // Make sure deck and hands are ready for a new game
        game.deal();   // Deal 2 cards each to the player and the dealer

        // Print the initial hands for both the player and the dealer
        System.out.println("Initial Game State:");
        System.out.println(game);

        // Let the player take their turn
        boolean playerContinues = game.playerTurn();
        System.out.println("\nAfter Player's Turn:");
        System.out.println(game);

        // If the player did not bust (go over 21), let the dealer take their turn
        if (playerContinues) {
            boolean dealerContinues = game.dealerTurn();
            System.out.println("\nAfter Dealer's Turn:");
            System.out.println(game);
        } else {
            // If the player busted, the game ends here
            System.out.println("\nPlayer busted! Dealer wins.");
        }
    }

    /**
     * Constructor — when a Blackjack object is created, it builds and shuffles the deck.
     */
    public Blackjack() {
        deck.build();     // Fills the deck with 52 cards
        deck.shuffle();   // Randomizes the order of the cards in the deck
    }

    /**
     * Resets the game state before a new round:
     * - Rebuilds the deck if fewer than 26 cards are left
     * - Clears the player’s and dealer’s hands
     */
    public void reset() {
        if (deck.size() < 26) {     // If half or more of the deck has been used
            deck.build();           // Rebuild a full deck
            deck.shuffle();         // Shuffle the new deck
        }

        player.reset();  // Remove all cards from the player's hand
        dealer.reset();  // Remove all cards from the dealer's hand
    }

    /**
     * Deals 2 cards each to the player and dealer.
     * Cards are dealt one at a time, alternating between player and dealer.
     */
    public void deal() {
        for (int i = 0; i < 2; i++) {         // Do this twice
            Card card1 = deck.deal();         // Take the top card from the deck for the player
            player.add(card1);                // Add it to the player's hand

            Card card2 = deck.deal();         // Take the next card for the dealer
            dealer.add(card2);                // Add it to the dealer's hand
        }
    }

    /**
     * Handles the player's turn: 
     * - The player keeps drawing cards while their total is 16 or less
     * 
     * @return true if player stays under or equal to 21 (safe), false if busted
     */
    public boolean playerTurn() {
        while (player.getTotalValue() <= 16) {   // While the hand is too low
            player.add(deck.deal());             // Draw a card and add it to the hand
        }
        return player.getTotalValue() <= 21;     // Return whether player is still in the game
    }

    /**
     * Handles the dealer's turn:
     * - Dealer must draw while under 17
     * 
     * @return true if dealer is still in the game (≤ 21), false if bust
     */
    public boolean dealerTurn() {
        while (dealer.getTotalValue() < 17) {    // Dealer draws until reaching 17 or more
            dealer.add(deck.deal());             // Draw one card
        }
        return dealer.getTotalValue() <= 21;     // Return whether dealer is still in the game
    }

    /**
     * Returns a formatted string of the current game state.
     * Displays the cards and total values for both the player and the dealer.
     */
    public String toString() {
        int playerTotal = player.getTotalValue();    // Get the total value of player's hand
        int dealerTotal = dealer.getTotalValue();    // Get the total value of dealer's hand

        StringBuilder gameState = new StringBuilder();  // For building the output string

        // Show player's hand
        gameState.append("Player's Hand: [");
        for (int i = 0; i < player.size(); i++) {
            gameState.append(player.getCard(i).getValue());  // Add card value
            if (i < player.size() - 1) {
                gameState.append(", ");                       // Separate values with comma
            }
        }
        gameState.append("] (Total: ").append(playerTotal).append(")\n");

        // Show dealer's hand
        gameState.append("Dealer's Hand: [");
        for (int i = 0; i < dealer.size(); i++) {
            gameState.append(dealer.getCard(i).getValue());  // Add card value
            if (i < dealer.size() - 1) {
                gameState.append(", ");
            }
        }
        gameState.append("] (Total: ").append(dealerTotal).append(")\n");

        return gameState.toString();  // Return the entire formatted game state
    }

    /**
     * Plays a complete round of the game (used in simulations).
     * Handles turns and returns result as an integer:
     * 
     * @param verbose whether or not to print the game state (not used here)
     * @return  1 if player wins, 
     *         -1 if dealer wins, 
     *          0 if draw
     */
    public int game(boolean verbose) {
        reset(); // Set up the deck and clear hands

        // Initial dealing of two cards each
        player.add(deck.deal());
        player.add(deck.deal());
        dealer.add(deck.deal());
        dealer.add(deck.deal());

        // Player's turn
        boolean playerStillIn = playerTurn(); 
        if (!playerStillIn) return -1;  // Player busted, dealer wins

        // Dealer's turn
        boolean dealerStillIn = dealerTurn(); 
        if (!dealerStillIn) return 1;   // Dealer busted, player wins

        // Final comparison of scores
        int playerScore = player.getTotalValue();
        int dealerScore = dealer.getTotalValue();

        if (playerScore > dealerScore) return 1;      // Player wins
        if (dealerScore > playerScore) return -1;     // Dealer wins
        return 0;                                     // It's a draw
    }


    /**
     * Handles the player's turn interactively by asking them whether they want to "hit" or "stand".
     * - "Hit" means the player wants to draw another card.
     * - "Stand" means the player wants to keep their hand as-is and end their turn.
     * 
     * The player continues to choose actions until they either bust (go over 21) or stand.
     * 
     * @return true if the player ends their turn without busting, false if they bust
     */
    public boolean playerTurnInteractive() {
        // Display the player's starting hand
        System.out.println("Your turn! Your current hand: " + player);

        while (true) { // Keep looping until the player either busts or chooses to stand
            System.out.print("Do you want to 'hit' or 'stand'? "); // Ask the player what they want to do
            
            // Read the player's input, trim any spaces, and convert to lowercase for comparison
            String action = scanner.nextLine().trim().toLowerCase();

            // If the player types "hit", they want another card
            if (action.equals("hit")) {
                player.add(deck.deal()); // Deal one card from the deck and add it to the player's hand
                System.out.println("Your hand: " + player); // Show updated hand

                // If the total value of the player's hand exceeds 21, they busted
                if (player.getTotalValue() > 21) {
                    System.out.println("You busted!"); // Notify the player
                    return false; // Player is out — return false to end their turn
                }

            } else if (action.equals("stand")) {
                // If the player chooses to stand, end the loop — their turn is done
                break;

            } else {
                // Catch invalid input and prompt again
                System.out.println("Invalid input. Please type 'hit' or 'stand'.");
            }
        }

        return true; // Player chose to stand and did not bust
    }

}
