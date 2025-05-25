/**
 * Author: Azeem Gbolahan
 * 
 * File: Simulation.java
 * 
 * Description:
 * This program provides two main options:
 * 1. Allows the user to play an interactive game of Blackjack through the terminal.
 * 2. Runs automatic simulations of Blackjack games (100, 1000, or 10,000 rounds) to determine 
 *    the player's win rate, dealer's win rate, and draw frequency using Monte Carlo simulation.
 * 
 * Menu Options:
 * - "Play Interactive Game": Play one round at a time, inputting "hit" or "stand" as the player.
 * - "Run Simulations": Automatically simulates many rounds and prints win percentages.
 * - "Exit": Closes the program.
 * 
 * This program builds on the Blackjack class, which handles game mechanics, turns, and scoring.
 * 
 * How to run:
 *   javac Simulation.java
 *   java Simulation
 */

 import java.util.Scanner;

 public class Simulation {
 
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);     // Scanner to receive user input
         Blackjack game = new Blackjack();              // Create a Blackjack game instance
 
         // Menu loop — keeps running until the user chooses to exit
         while (true) {
             // Print menu options
             System.out.println("\nBLACKJACK SIMULATOR");
             System.out.println("----------------------");
             System.out.println("1. Play Interactive Game");
             System.out.println("2. Run Simulations");
             System.out.println("3. Exit");
             System.out.print("Enter your choice: ");
 
             int choice = scanner.nextInt();   // Get the user’s menu selection
             scanner.nextLine();               // Consume leftover newline character
 
             // Handle user's selection
             if (choice == 1) {
                 playInteractiveGame(game, scanner); // Run the interactive game
             } else if (choice == 2) {
                 runSimulations(game);              // Run simulations of many games
             } else if (choice == 3) {
                 System.out.println("Exiting the program. Goodbye!"); // Exit message
                 break; // End the loop and terminate the program
             } else {
                 // If input is invalid (not 1–3), prompt the user again
                 System.out.println("Invalid choice! Please enter 1, 2, or 3.");
             }
         }
 
        scanner.close(); // Close the scanner when done
     }
 
     /**
      * Starts the interactive version of Blackjack for the user to play.
      * The user is asked after each round whether they want to play again.
      *
      * @param game    the Blackjack object that handles game logic
      * @param scanner the Scanner used to read user input
      */
     private static void playInteractiveGame(Blackjack game, Scanner scanner) {
         System.out.println("\nStarting Interactive Blackjack Game...");
 
         while (true) {
             int result = game.game(true); // Play one round in interactive (verbose) mode
 
             // Check game result and print outcome
             if (result == 1) {
                 System.out.println("🎉 You win!");
             } else if (result == -1) {
                 System.out.println("😞 Dealer wins!");
             } else {
                 System.out.println("🤝 It's a draw!");
             }
 
             // Ask if user wants to play again
             System.out.print("Would you like to play again? (yes/no): ");
             String playAgain = scanner.nextLine().trim().toLowerCase();
 
             if (!playAgain.equals("yes")) {
                 System.out.println("Thanks for playing!");
                 break; // Exit the loop and return to the main menu
             }
         }
     }
 
     /**
      * Runs a set of automatic Blackjack simulations (non-interactive).
      * It prints out the win percentages for player, dealer, and draws.
      *
      * @param game the Blackjack object that handles game logic
      */
     private static void runSimulations(Blackjack game) {
         int[] simulationCounts = {100, 1000, 10000}; // Define how many games to simulate
 
         System.out.println("\nBLACKJACK SIMULATION RESULTS");
         System.out.println("------------------------------------------------");
 
         // Run a simulation for each game count (e.g., 100 games, 1000 games, etc.)
         for (int numGames : simulationCounts) {
             int playerWins = 0; // Count how many games the player wins
             int dealerWins = 0; // Count how many games the dealer wins
             int draws = 0;      // Count how many games end in a tie
 
             // Simulate numGames rounds of Blackjack
             for (int i = 0; i < numGames; i++) {
                 int result = game.game(false); // Play in non-interactive mode
 
                 // Update the appropriate counter based on game result
                 if (result == 1) {
                     playerWins++;
                 } else if (result == -1) {
                     dealerWins++;
                 } else {
                     draws++;
                 }
             }
 
             // Convert raw counts into percentages
             double playerWinPercent = (double) playerWins / numGames * 100;
             double dealerWinPercent = (double) dealerWins / numGames * 100;
             double drawPercent = (double) draws / numGames * 100;
 
             // Print the results for this batch
             System.out.println("Simulation for " + numGames + " games:");
             System.out.printf("  Player Wins:  %d (%.2f%%)%n", playerWins, playerWinPercent);
             System.out.printf("  Dealer Wins:  %d (%.2f%%)%n", dealerWins, dealerWinPercent);
             System.out.printf("  Draws:        %d (%.2f%%)%n", draws, drawPercent);
             System.out.println("------------------------------------------------");
         }
     }
 }
 