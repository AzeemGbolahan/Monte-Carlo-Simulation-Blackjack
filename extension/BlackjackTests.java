/*
file name:      BlackjackTests.java
Author:        Azeem Gbolahan
last modified:  5/24/2025

How to run:     java -ea BlackjackTests
*/

//Expected results:
//Draw percent: 8 +/- 1
//Dealer win percent: 49 +/- 1
//Player win percent: 41 +/1 1


public class BlackjackTests {

   
    public static void blackjackTests() {
        Blackjack game = new Blackjack();
        int playerWins = 0;
        int dealerWins = 0;
        int draws = 0;
        int totalGames = 10000;

        // Simulate 10,000 Blackjack games
        for (int i = 0; i < totalGames; i++) {
            int result = game.game(false); // Run the game (false means no verbose output)

            // Count the outcomes
            if (result == 1) {
                playerWins++;
            } else if (result == -1) {
                dealerWins++;
            } else {
                draws++;
            }
        }

        // Calculate and print the percentages of each outcome
        double playerWinPercent = (double) playerWins / totalGames * 100;
        double dealerWinPercent = (double) dealerWins / totalGames * 100;
        double drawPercent = (double) draws / totalGames * 100;

        System.out.println("After 10,000 games:");
        System.out.println("Player Wins: " + playerWinPercent + "%");
        System.out.println("Dealer Wins: " + dealerWinPercent + "%");
        System.out.println("Draws: " + drawPercent + "%");

        if (Math.abs(playerWinPercent - 41) > 1) {
            System.out.println("❌ Player win percentage out of range: " + playerWinPercent + "%");
            assert false;
        }
        if (Math.abs(dealerWinPercent - 49) > 1) {
            System.out.println("❌ Dealer win percentage out of range: " + dealerWinPercent + "%");
            assert false;
        }
        if (Math.abs(drawPercent - 8) > 1) {
            System.out.println("❌ Draw percentage out of range: " + drawPercent + "%");
            assert false;
        }

    }

    public static void main(String[] args) {

        blackjackTests();
    }

    
}

