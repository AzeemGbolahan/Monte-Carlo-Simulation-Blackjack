/*
file name:      CardTests.java
Author:        Azeem Gbolahan
last modified:  05/24/2025

How to run:     java -ea CardTests
*/


public class CardTests {

    public static void cardTests() {
        
        // case 1: testing Card(i)
        {
            // set up
            Card c1 = new Card(5);
            Card c2 = new Card(10);

            // verify
            System.out.println(c1 + " == 5");
            System.out.println(c2 + " == 10");

            // test
            assert c1 != null : "Error in Card::Card()";
            assert c2 != null : "Error in Card::Card()";
        }

        // case 2: testing getValue()
        {
            // set up
            Card c1 = new Card(5);
            Card c2 = new Card(10);

            // verify
            System.out.println(c1.getValue() + " == 5");
            System.out.println(c2.getValue() + " == 10");

            // test
            assert c1.getValue() == 5 : "Error in Card::Card() or Card::getValue()";
            assert c2.getValue() == 10 : "Error in Card::Card() or Card::getValue()";
        }

        // case 3: testing toString()
        {
            // set up
            Card c1 = new Card(5);
            Card c2 = new Card(10);

            // verify
            System.out.println(c1.toString() + " == 5");
            System.out.println(c2.toString() + " == 10");

            // test
            assert c1.toString().equals("5") : "Error in Card::toString()";
            assert c2.toString().equals("10") : "Error in Card::toString()";
        }

        System.out.println("*** Done testing Card! ***\n");
    }


    public static void main(String[] args) {

        cardTests();
    }
}
