/**
 * Author: Azeem Gbolahan
 * Purpose of the class: This is a card object that holds all the information unique to a card e.g. the value of the card
 *
 */
public class Card {

    /**
     * The value of the card.
     */
    private int value;

    /**
     * Constructs a card with the specified value.
     * @param val
     */
    public Card(int val) {
        this.value = val;
    }

    /**
     * Returns the value of the card.
     * @return the value of the card
     */
    public int getValue() {

        return this.value;
    }
    
    /**
     * Returns a string representation of this card.
     * @return a string representation of this card
     */
    public String toString() {
        return Integer.toString(this.value);
        
    }
}

