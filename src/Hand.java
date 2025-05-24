/**
 * Author: Azeem Gbolahan
 * Purpose of the class: This class represents a hand of cards in a card game. 
 * It uses a custom ArrayList to manage the collection of Card objects in the hand.
 */
public class Hand {

    /** An ArrayList that holds all the cards currently in the hand */
    private ArrayList<Card> mycards;

    /**
     * Constructor — creates an empty hand using an ArrayList of Cards.
     * When a Hand object is created, it starts off with no cards.
     */
    public Hand() {
        mycards = new ArrayList<Card>(); // initialize an empty ArrayList to store the cards in the hand
    }

    /**
     * Clears all the cards currently in the hand.
     * This is useful when starting a new round or resetting the game state.
     */
    public void reset() {
        while (mycards.size() > 0) { // as long as there are cards in the hand
            mycards.remove(mycards.size() - 1); // remove the last card one by one until the hand is empty
        }
    }

    /**
     * Adds a single card to the hand.
     * 
     * @param card the card to be added
     */
    public void add(Card card) {
        mycards.add(card); // insert the new card at the end of the hand
    }

    /**
     * Returns the number of cards currently in the hand.
     * 
     * @return the total number of cards in the hand
     */
    public int size() {
        return mycards.size(); // call the size method from the ArrayList class to get number of cards
    }

    /**
     * Retrieves a specific card from the hand based on its position.
     * 
     * @param index the index of the card (starting from 0)
     * @return the card at that position
     */
    public Card getCard(int index) {
        return mycards.get(index); // return the card at the specified index
    }

    /**
     * Calculates and returns the total value of all cards in the hand.
     * Useful for scoring purposes in games like Blackjack.
     * 
     * @return the total value of the hand
     */
    public int getTotalValue() {
        int total = 0; // this will hold the sum of all card values

        for (int i = 0; i < mycards.size(); i++) { // go through every card in the hand
            Card card = mycards.get(i); // get the card at position i
            if (card != null) { // only if the card actually exists (not null)
                total += card.getValue(); // add the card's value to the running total
            } else {
                total += 0; // if the card is null, it contributes nothing to the total
            }
        }

        return total; // return the final computed value of the hand
    }

    /**
     * Converts the hand into a human-readable string format.
     * 
     * Example output: [10, 5, 2] : 17
     * This helps in displaying the hand contents along with its total value.
     * 
     * @return the string representation of the hand
     */
    @Override
    public String toString() {
        int total = 0; // total value of the hand
        StringBuilder handString = new StringBuilder("["); // using StringBuilder for efficient string building

        for (int i = 0; i < mycards.size(); i++) {
            int val = mycards.get(i).getValue(); // get the value of the current card
            total += val; // add the value to the total
            handString.append(val); // add the value to the string

            // add a comma if this is not the last card
            if (i < mycards.size() - 1) {
                handString.append(", ");
            }
        }

        handString.append("] : ").append(total); // add total to the end like "[3, 4, 10] : 17"
        return handString.toString(); // return the final string
    }
}
