/**
 * Author: Azeem Gbolahan
 * Purpose of the class: A basic implementation of an ArrayList that provides
 * basic operations for adding and removing elements at the end of the ArrayList
 * as well as getting and setting elements at a specified index.
 *
 * @param <T> the type of elements stored in the list
 */
public class ArrayList<T> {

    /** The underlying array (0-indexed) that holds elements of type T */ 
    private T[] arr;

    /** The number of elements currently in the ArrayList */
    private int size;

    /** 
     * Default constructor — initializes the array with a capacity of 1
     */
    public ArrayList(){
        initializeArray(1); // Start with an array that can hold 1 element
        size = 0;           // Initially, the list is empty
    }

    /** 
     * Constructor that initializes the array with a specified initial capacity
     * 
     * @param initialCapacity the initial capacity of the ArrayList
     */
    public ArrayList(int initialCapacity){
        initializeArray(initialCapacity); // Create an array with the given size
        size = 0;                          // Start with no elements in it
    }

    /**
     * Returns the number of elements currently in the list
     * 
     * @return the size of the ArrayList
     */
    public int size() {
        return size; // Simply return the number of items stored
    }

    /**
     * Adds an item to the end of the list.
     *
     * @param item the item to add to the list
     */
    public void add(T item) {
        // If the array is full (can't fit any more items), double its capacity
        if (size >= arr.length) {
            this.changeCapacity(arr.length * 2); // Create a bigger array and move everything over
        }

        // Place the item at the position equal to current size (end of the list)
        arr[size] = item;

        // Increase size by 1 to reflect the new element
        size++;
    }

    /**
     * Retrieves the element at the specified index
     *
     * @param index the position of the element to retrieve
     * @return the element at the specified index
     */
    public T get(int index) {
        return arr[index]; // Return whatever is at the given index
    }

    /**
     * Sets the element at the specified index to a new item
     *
     * @param item the item to place at the index
     * @param index the index to update
     */
    public void set(int index, T item) {
        // Only update if the index is valid (within the current size)
        if (index < this.size) {
            arr[index] = item; // Replace the item at this position
        }
    }

    /**
     * Removes and returns the element at the specified index
     *
     * @param index the index of the element to remove
     * @return the removed element
     */
    public T remove(int index) {
        T out = arr[index]; // Store the item to return later

        // Shift every element after the removed item one place to the left
        for (int i = index + 1; i < size; i++) {
            arr[i - 1] = arr[i]; // This effectively overwrites the removed item
        }

        size--;             // Decrease the total size (we removed something)
        arr[size] = null;   // Clean up the last spot (which is now empty)

        return out;         // Return the item that was removed
    }

    /**
     * Changes the capacity of the internal array
     *
     * @param newCapacity the new desired capacity
     */
    private void changeCapacity(int newCapacity) {
        T[] oldArr = arr;               // Save the current array
        initializeArray(newCapacity);   // Make a new, larger (or smaller) array

        // Copy over each element from the old array to the new one
        for (int i = 0; i < size; i++) {
            arr[i] = oldArr[i]; // Copy items one-by-one
        }
    }

    /**
     * Initializes the internal array with a given capacity
     *
     * @param capacity the capacity of the new array
     */
    @SuppressWarnings("unchecked")
    private void initializeArray(int capacity) {
        // Create a generic Object array and cast it to type T[]
        arr = (T[]) new Object[capacity];
    } 

    /**
     * Overrides toString to display the contents of the ArrayList in a readable format
     *
     * @return a string representation of the list
     */
    @Override 
    public String toString() {
        String output = "["; // Start with an opening bracket

        // Loop through every item in the list (from 0 to size - 1)
        for (int i = 0; i < size; i++) {
            output += arr[i]; // Add the item to the string

            // Add a comma after each item, except the last one
            if (i < size - 1) {
                output += ", ";
            }
        }

        output += "]"; // Close the bracket to end the list
        return output; // Return the full string
    }
}
