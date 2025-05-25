/**
 * Author: Azeem Gbolahan
 * 
 * File: Interactive.java
 * 
 * Description:
 * This class allows a user to play an interactive version of Blackjack through the terminal.
 * It uses the `Blackjack` class to manage gameplay while prompting the user to "hit" or "stand".
 * The game continues in a loop until the player chooses to stop.
 *
 * Gameplay Flow:
 * - The game greets the player and resets the deck and hands.
 * - The player is dealt two cards and decides whether to continue drawing or to stand.
 * - The dealer then takes their turn according to Blackjack rules (must hit until 17+).
 * - The game determines and prints the winner or declares a draw.
 *
 * How to run: 
 * Compile and run the file using:
 *     javac Interactive.java
 *     java -ea Interactive
 */

 import java.util.Scanner;

 public class Interactive {
 
     // Scanner for user input throughout the game
     private Scanner scanner = new Scanner(System.in);
 
     public static void main(String[] args) {
         // Start the interactive Blackjack game
         System.out.println("Welcome to the game!");
 
         // Create an instance of this class and run the play logic
         Interactive game = new Interactive(); 
         game.play(); // Begin interactive gameplay loop
     }
 
     /**
      * Handles one or more full games of Blackjack, based on user input.
      * The player can choose to play repeatedly until they say "no".
      */
     public void play() {
         Blackjack game = new Blackjack(); // Create a new instance of the Blackjack game
 
         while (true) { // Keep playing until the player says "no"
             game.reset(); // Reset deck and clear hands
             game.deal();  // Deal 2 cards each to player and dealer
 
             System.out.println("\nWelcome to Blackjack!");
             System.out.println(game); // Show initial hands and totals
 
             // Player takes their turn interactively
             boolean playerContinues = game.playerTurnInteractive(); 
             if (!playerContinues) {
                 // Player busted
                 System.out.println("Dealer wins!");
             } else {
                 // Dealer's turn
                 boolean dealerContinues = game.dealerTurn(); 
                 System.out.println("\nFinal Game State:");
                 System.out.println(game); // Show final hands and totals
 
                 // Check who won based on the final scores
                 if (!dealerContinues) {
                     System.out.println("Dealer busted! You win!");
                 } else {
                     int result = game.game(false); // Run game logic to get winner
                     if (result == 1) {
                         System.out.println("You win!");
                     } else if (result == -1) {
                         System.out.println("Dealer wins!");
                     } else {
                         System.out.println("It's a draw!");
                     }
                 }
             }
 
             // Ask the player if they want to play again
             System.out.print("\nWould you like to play again? (yes/no): ");
             String playAgain = scanner.nextLine().trim().toLowerCase();
 
             if (!playAgain.equals("yes")) {
                 System.out.println("Thanks for playing!");
                 break; // Exit the loop and end the program
             }
         }
         scanner.close();
     }
 }
 