/*
* Programmer: Rion Seekings
* Title: Card class
* Date: Nov 18, 2022
* Desc: Access suit, rank, and point value of cards.
* Class: CompSci-AP MWF 10:00 a.m.
*/

/**
 * Card.java
 *
 * <code>Card</code> represents a playing card.
 */
public class Card {
/**
 * String value that holds the suit of the card
 */
   private String suit;
/**
 * String value that holds the rank of the card
 */
   private String rank;
/**
 * int value that holds the point value.
 */
   private int pointValue;
   /**
 * Creates a new <code>Card</code> instance.
 *
 * @param cardRank  a <code>String</code> value
 *                  containing the rank of the card
 * @param cardSuit  a <code>String</code> value
 *                  containing the suit of the card
 * @param cardPointValue an <code>int</code> value
 *                  containing the point value of the card
 */
   public Card(String cardRank, String cardSuit, int cardPointValue) {
   /* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
      rank = cardRank; //set rank to parameter recieved
      suit = cardSuit;  //set suit to parameter recieved
      pointValue = cardPointValue; //set pointValue to parameter received
   }
/**
 * Accesses this <code>Card's</code> suit.
 * @return this <code>Card's</code> suit.
 */
   public String suit() {
   /* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
      return suit; //return current suit
   }
/**
 * Accesses this <code>Card's</code> rank.
 * @return this <code>Card's</code> rank.
 */
   public String rank() {
   /* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
      return rank; //return current rank
   }
   /**
 * Accesses this <code>Card's</code> point value.
 * @return this <code>Card's</code> point value.
 */
   public int pointValue() {
   /* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
      return pointValue; //return current pointValue
   }
/** Compare this card with the argument.
 * @param otherCard the other card to compare to this
 * @return true if the rank, suit, and point value of this card
 *              are equal to those of the argument;
 *         false otherwise.
 */
   public boolean matches(Card otherCard) {
   /* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
      boolean result = false;
      if (this.rank.equals(otherCard.rank()) && 
         this.suit.equals(otherCard.suit()) && 
         this.pointValue == (otherCard.pointValue())) //if all values match between two cards...
         
         result = true;                               //...set boolean to true...
   
   
      return result;                                  //...otherwise, leave as false
   }
/**
 * Converts the rank, suit, and point value into a string in the format
 *     "[Rank] of [Suit] (point value = [PointValue])".
 * This provides a useful way of printing the contents
 * of a <code>Deck</code> in an easily readable format or performing
 * other similar functions.
 *
 * @return a <code>String</code> containing the rank, suit,
 *         and point value of the card.
 */
   @Override
   public String toString() {
   /* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
      String result = ""; //create local string variable
      result = "['" + this.rank + "','" + suit + "']";
      return result; //return 'snapshot' of the current data
   }
}