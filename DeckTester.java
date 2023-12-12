/*
* Programmer: Rion Seekings
* Title: DeckTester class
* Date: Nov 30, 2022
* Desc: Make a program that makes three decks and runs the methods of tbe deck class
* Class: CompSci-AP MWF 10:00 a.m.
*/
/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
   public static void main(String[] args) {
   	/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
      String[] myranks = {"3", "3", "4", "7", "10", "Jack", "King", "King"};
      String[] mysuits = {"Spades", "Diamonds", "Hearts", "Clubs"}; //make deck with various cards
      int[] myptval = {3,3,4,7,10,10,10,10};
      Deck mydeck = new Deck(myranks, mysuits, myptval);
      System.out.println(mydeck);
      
      String[] ranks2 = {"A", "2", "5", "8", "9", "9", "9", "Queen"};
      String[] suits2 = {"Spades", "Diamonds", "Hearts", "Clubs"}; //make deck with various cards
      int[] ptvals2 = {1,2,5,8,9,9,9,10};
      Deck deck2 = new Deck(ranks2, suits2, ptvals2);
      System.out.println(deck2);
      
      String[] ranks3 = {"2", "2", "6", "7", "Jack", "Jack"};
      String[] suits3 = {"Spades", "Diamonds", "Hearts", "Clubs"}; //make deck with various cards
      int[] ptvals3 = {2,2,6,7,10,10};
      Deck deck3 = new Deck(ranks3, suits3, ptvals3);
      System.out.println(deck3);
      
      System.out.println("Deck 1:");
      System.out.println(mydeck.isEmpty());
      System.out.println(mydeck.deal()); //run all methods for this deck
      System.out.println(mydeck.size());
      System.out.println();
      
      System.out.println("Deck 2:");
      System.out.println(deck2.isEmpty());
      System.out.println(deck2.deal()); //run all methods for this deck
      System.out.println(deck2.size());
      System.out.println();
      
      System.out.println("Deck 3:");
      System.out.println(deck3.isEmpty());
      System.out.println(deck3.deal()); //run all methods for this deck
      System.out.println(deck3.size());
      
      mydeck.shuffle();
      deck2.shuffle();
      deck3.shuffle();
      System.out.println(mydeck);
      System.out.println(deck2);
      System.out.println(deck3);
   }
}