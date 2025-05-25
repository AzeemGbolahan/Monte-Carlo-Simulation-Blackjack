import java.util.Random;

/**
 * Author: Azeem Gbolahan
 * Purpose of the class: This class represents a full deck of cards.
 * It handles creating a 52-card deck, shuffling, and dealing cards—using
 * an ArrayList to store and manage the cards.
 */
public class Deck {

    /** The list that holds all the cards currently in the deck */
    ArrayList<Card> mydeck;

    /**
     * Constructor — sets up the deck by first creating an empty list
     * and then filling it with cards using the build() method.
     */
    public Deck() {
        this.mydeck = new ArrayList<Card>(); // Creates an empty list to represent the deck
        build(); // Fills the list with a standard 52-card setup
    }

    /**
     * Builds a standard 52-card deck by:
     * 1. Clearing any existing cards.
     * 2. Adding 4 of each card from 2 to 9.
     * 3. Adding 16 cards of value 10 (for 10, J, Q, K).
     * 4. Adding 4 cards of value 11 (for Aces).
     */
    public void build() {
        // Step 1: Remove any existing cards from the deck (just in case)
        for (int i = mydeck.size() - 1; i >= 0; i--) {
            mydeck.remove(i); // Remove cards from last to first
        }

        // Step 2: Add 4 cards each for values 2 to 9 (representing four suits)
        for (int i = 2; i <= 9; i++) {
            for (int y = 0; y < 4; y++) {
                Card card = new Card(i); // Create a card with value i
                mydeck.add(card);        // Add it to the deck
            }
        }

        // Step 3: Add 16 cards of value 10 (represents 10, Jack, Queen, King across 4 suits)
        for (int y = 0; y < 16; y++) {
            Card card = new Card(10); // All face cards have a value of 10
            mydeck.add(card);         // Add each to the deck
        }

        // Step 4: Add 4 Aces, each with a value of 11
        for (int v = 0; v < 4; v++) {
            Card card = new Card(11); // Aces represented with value 11
            mydeck.add(card);         // Add Ace to the deck
        }
    }

    /**
     * Returns the number of cards left in the deck.
     * 
     * @return the size of the deck (number of remaining cards)
     */
    public int size() {
        return mydeck.size(); // Returns how many cards are in the deck right now
    }

    /**
     * Deals (removes and returns) the top card of the deck.
     * 
     * @return the first card from the deck
     */
    public Card deal() {
        return mydeck.remove(0); // Remove and return the first card (top of the deck)
    }

    /**
     * Shuffles the deck using random swaps between cards.
     * This ensures that cards are in random order before dealing.
     */
    public void shuffle() {
        Random randomizer = new Random(); // Create a random number generator

        // Go through each card in the deck
        for (int i = 0; i < mydeck.size(); i++) {
            // Pick two random indices (positions) in the deck
            int randomindex = randomizer.nextInt(mydeck.size() - i);
            int randomindex2 = randomizer.nextInt(mydeck.size() - i);

            // Get the cards at those random positions
            Card mycard = mydeck.get(randomindex);
            Card mycard2 = mydeck.get(randomindex2);

            // Swap the two cards
            mydeck.set(randomindex, mycard2);
            mydeck.set(randomindex2, mycard);
        }
    }

    /**
     * Returns a string showing all the card values in the deck and their total value.
     * Example: [2, 3, 10, 11] : 26
     * 
     * @return a string representation of the current deck
     */
    public String toString() {
        int total = 0; // Will store the sum of all card values in the deck
        StringBuilder handString = new StringBuilder("["); // Use StringBuilder for efficient string building

        // Go through each card in the deck
        for (int i = 0; i < mydeck.size(); i++) {
            int val = mydeck.get(i).getValue(); // Get the card's value
            total += val;                       // Add it to the running total
            handString.append(val);             // Append value to the string

            // Add a comma after every card except the last one
            if (i < mydeck.size() - 1) {
                handString.append(", ");
            }
        }

        // Close the bracket and add the total sum
        handString.append("] : ").append(total);
        return handString.toString(); // Return the completed string
    }
}
