/*
* Programmer: Rion Seekings
* Title: Deck class
* Date: Nov 30, 2022
* Desc: Make a program that creates a deck from cards that are made with the Card class
* Class: CompSci-AP MWF 10:00 a.m.
*/
import java.util.List;
import java.util.ArrayList;
//import java.util.Math;

/**
 * The Deck class represents a shuffled deck of cards.
 * It provides several operations including
 *      initialize, shuffle, deal, and check if empty.
 */
public class Deck {

	/**
	 * cards contains all the cards in the deck.
	 */
   //private List<Card> cards;
   
   private final int DECKSIZE = 52; //makes sure decks cannot exceed 52 cards
   private Card[] cards;

	/**
	 * size is the number of not-yet-dealt cards.
	 * Cards are dealt from the top (highest index) down.
	 * The next card to be dealt is at size - 1.
	 */
   private int size;


	/**
	 * Creates a new <code>Deck</code> instance.<BR>
	 * It pairs each element of ranks with each element of suits,
	 * and produces one of the corresponding card.
	 * @param ranks is an array containing all of the card ranks.
	 * @param suits is an array containing all of the card suits.
	 * @param values is an array containing all of the card point values.
	 */
   public Deck(String[] ranks, String[] suits, int[] values) {
   	/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
      cards = new Card[DECKSIZE]; //makes an array with size of preset max decksize
      
      int i = 0;
      int  pos = 0;
      
      for (String suit : suits) //runs through all suits
      {
         i = 0;
         for (String rank : ranks) //for each suit, run thru all ranks as well
         {
            //System.out.println(suit + " " + rank);
            Card mycard = new Card(rank, suit, values[i]); //make a card for each rank with different suits
                                                           //and a point value that is equal to variable i.
            i++; //increment i so that each card has desired point value
            
            //System.out.println(mycard); //print newly made card
            
            cards[pos]=mycard; //add new card into the cards array at index value of pos
            pos++; //increment pos so that each card will be placed into diff index
         }
      }
      size = pos; //size of deck is equal to position of last card
   }


	/**
	 * Determines if this deck is empty (no undealt cards).
	 * @return true if this deck is empty, false otherwise.
	 */
   public boolean isEmpty() {
   	/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
      boolean answer = false; //set is defaulty as not empty
      if (size == 0)
         answer = true; //if the size of the deck is 0, then isEmpty is true
         
      return answer; //return the state of isEmpty (t/f)
   }

	/**
	 * Accesses the number of undealt cards in this deck.
	 * @return the number of undealt cards in this deck.
	 */
   public int size() {
   	/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
      return size; //get size of deck
   }

	/**
	 * Randomly permute the given collection of cards
	 * and reset the size to represent the entire deck.
	 */
   public void shuffle() {
   	/* *** TO BE IMPLEMENTED IN ACTIVITY 4 *** */
      for (int lastPos = size-1; lastPos>0; lastPos--)
      {
         int pick = (int) (Math.random()*(lastPos+1)); //cast as int so random number doesn't go above length
         Card temp = cards[pick]; //Switch
         cards[pick] = cards[lastPos];
         cards[lastPos] = temp;
      }
   
   }
	/**
	 * Deals a card from this deck.
	 * @return the card just dealt, or null if all the cards have been
	 *         previously dealt.
	 */
   public Card deal() {
   	/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
      if (size != 0) //only deal if size of deck isn't zero
      {
         Card dealtcard = cards[size-1]; //make dealtcard
         size--; //decrement size so that next deal can work
         return dealtcard; //return dealt card
      }
      else
      {
         Card dealtcard = cards[size]; //if size is zero, do nothing
         return dealtcard; //return the card that had nothing done to it
      }
   }

	/**
	 * Generates and returns a string representation of this deck.
	 * @return a string representation of this deck.
	 */
   @Override
   public String toString() {
          		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
      
      String result = "DRAW PILE\n"; //title dump DRAW PILE
      for (int i = 0; i < size; i++)
         result += cards[i].toString() + "\n"; //dump each card then make a new line
      result += "\n DEALT CARDS\n"; //title next dump DEALT CARDS
      for (int i = size; i < DECKSIZE; i++)
         result += cards[i] + "\n"; // dump dealt cards then make new line
      return result; //return all information
      
      
   }
}