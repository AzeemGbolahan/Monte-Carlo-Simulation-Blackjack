/**
 * Author: Azeem Gbolahan
 * 
 * File: Simulation.java
 * 
 * Purpose:
 * This class runs a Monte Carlo simulation of a simplified Blackjack game.
 * It uses repeated trials to determine how often the player wins, the dealer wins,
 * or the game ends in a draw. The more games simulated, the closer the result
 * approaches theoretical probabilities.
 *
 * Each simulation runs a large number of rounds (e.g., 1000),
 * and it prints out win percentages for the player and dealer, plus draw rates.
 */

 public class Simulation {

    /**
     * Main method — the entry point of the simulation.
     * It runs a set number of Blackjack games and summarizes the outcomes.
     */
    public static void main(String[] args) {

        int[] simulationCounts = {1000}; // Define how many games to simulate — here, 1000
        Blackjack game = new Blackjack(); // Create a single Blackjack game object to reuse

        // Header for the output
        System.out.println("BLACKJACK SIMULATION RESULTS");
        System.out.println("------------------------------------------------");

        // Loop over each simulation count (can support more than one, if added to array)
        for (int numGames : simulationCounts) {

            // Initialize counters for each possible outcome
            int playerWins = 0; // Track how many games the player wins
            int dealerWins = 0; // Track how many games the dealer wins
            int draws = 0;      // Track how many games end in a tie

            // Simulate 'numGames' rounds of Blackjack
            for (int i = 0; i < numGames; i++) {
                int result = game.game(false); // Run a single round of Blackjack

                // Update counters based on game result
                if (result == 1) {
                    playerWins++;   // Player won
                } else if (result == -1) {
                    dealerWins++;   // Dealer won
                } else {
                    draws++;        // Game was a draw
                }
            }

            // Convert raw counts into percentages
            double playerWinPercent = (double) playerWins / numGames * 100;
            double dealerWinPercent = (double) dealerWins / numGames * 100;
            double drawPercent = (double) draws / numGames * 100;

            // Display the results for this simulation set
            System.out.println("Simulation for " + numGames + " games:");
            System.out.printf("  Player Wins:  %d (%.2f%%)%n", playerWins, playerWinPercent);
            System.out.printf("  Dealer Wins:  %d (%.2f%%)%n", dealerWins, dealerWinPercent);
            System.out.printf("  Draws:        %d (%.2f%%)%n", draws, drawPercent);
            System.out.println("------------------------------------------------");
        }
    }
}
