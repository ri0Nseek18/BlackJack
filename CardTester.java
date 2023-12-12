/*
* Programmer: Rion Seekings
* Title: CardTester class
* Date: Nov 18, 2022
* Desc: Test to see if methods in Card class are working properly
* Class: CompSci-AP MWF 10:00 a.m.
*/

/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
   public static void main(String[] args) {
   	Card c1 = new Card("Queen", "Hearts", 11);
      Card c2 = new Card("Queen", "Hearts", 11);
      Card c3 = new Card("8", "Diamonds", 8);
      
      System.out.println("The rank of card c1 is " + c1.rank());
      System.out.println("The suit of card c1 is " + c1.suit());
      System.out.println("The point value of card c1 is " + c1.pointValue());
      
      System.out.println("Card c1 matches card c2: " + c1.matches(c2));
      System.out.println("Card c1 matches card c3: " + c1.matches(c3));
      
      System.out.println("Current state of card: " + c1);
      
      System.out.println();
      
      System.out.println("The rank of card c2 is " + c2.rank());
      System.out.println("The suit of card c2 is " + c2.suit());
      System.out.println("The point value of card c2 is " + c2.pointValue());
      
      System.out.println("Card c2 matches card c1: " + c2.matches(c1));
      System.out.println("Card c2 matches card c3: " + c2.matches(c3));
      
      System.out.println("Current state of card: " + c2);
      
      System.out.println();
      
      System.out.println("The rank of card c3 is " + c3.rank());
      System.out.println("The suit of card c3 is " + c3.suit());
      System.out.println("The point value of card c3 is " + c3.pointValue());
      
      System.out.println("Card c3 matches card c1: " + c3.matches(c1));
      System.out.println("Card c3 matches card c2: " + c3.matches(c2));
      
      System.out.println("Current state of card: " + c3);
   }
}
