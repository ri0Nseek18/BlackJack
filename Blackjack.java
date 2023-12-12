/*
* Programmer: Rion Seekings
* Title: Blackjack class
* Date: Dec 7, 2022
* Desc: Make a sophisitcated program that runs thru a blackjack game
* Class: CompSci-AP MWF 10:00 a.m.
*/
import java.util.Scanner;
import java.util.ArrayList;
/**
    * This class set up and executes a game of Blackjack.
    */
public class Blackjack {
   /**
      * Main method of Blackjack.java
       * Blackjack.java is a class where a player (manually controlled)
       * plays against a dealer in a game of traditional blackjack.
       * @param args contain methods that take user's input
       * and runs a game of blackjack where the user chooses to 
       * cheat or play regularly.
       */
   public static void main(String[] args) {
   
   // Makes the deck and makes the hands for the dealer and the player.
   
      String[] ranks = {"ACE", "2", "3", "4", "5", "6", "7", "8", "9",
         "10", "JACK", "QUEEN", "KING"};
      int[] values = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
      String[] suits = {"CLUB", "DIAMOND", "HEART", "SPADE"};
      Deck deck = new Deck(ranks, suits, values);
      ArrayList<Card> playerHand = new ArrayList<Card>();
      ArrayList<Card> dealerHand = new ArrayList<Card>();
   
     // Creates a scanner to take input from the player.
      Scanner scanner = new Scanner(System.in);
      System.out.print("Cheat mode? (Yes, No): ");
      String cheatMode = scanner.nextLine(); 
      System.out.println(cheatMode);              
      /*
      * Checks to see if the cheat mode is turned on or off then
      * if it's on it receives the num of cards that the player wants
      * to discard.
      */
      int numOfDiscards = 0;
      if (cheatMode.equalsIgnoreCase("Yes")) {
         System.out.print("How many discards?(0 - 26): ");
         numOfDiscards = scanner.nextInt();
         System.out.println(numOfDiscards + "\n");
         
         /*
         * The card discard section of the class that allows
         * player to be in cheat mode.
         */
         for (int i = 0; i < numOfDiscards; i++) {
            deck.deal();
         }
      }  
   //Shuffles the deck if cheat mode is not turned on.  
      if (cheatMode.equalsIgnoreCase("No")) {
         deck.shuffle();
      } 
     
   //Deals cards to the player and the dealer respectively.
      playerHand.add(deck.deal());
      dealerHand.add(deck.deal());
      playerHand.add(deck.deal());
      dealerHand.add(deck.deal());
      
      System.out.print("You are currently at " + getScore(playerHand) 
         + "\nwith the hand ");
      System.out.println(printHand(playerHand));
     
   //bj game + globals
      boolean playerBust = false;
      boolean dealerBust = false;
      boolean loop = false;
    
      while (!playerBust && !loop && !dealerBust) {
      //Questions the player if they want another card(a hit).
         System.out.print("Hit or stay?(Hit = 1, Stay = 0) ");
         int hit = scanner.nextInt();
         System.out.println(hit);
      
      //Checks if the player wants another card(a hit).
         while (hit == 1) {
            if (getScore(playerHand) <= 21) {
               playerHand.add(deck.deal());
            }
            else if ((getScore(playerHand)) > 21) {
               System.out.println("Bust");
               System.out.print("You are currently at: "
                  + getScore(playerHand) + "\nwith the hand ");
               System.out.println(printHand(playerHand));
               System.out.println("Dealer wins!");
               playerBust = true;
               break;
            }
            //Advances onwards if the player wants to do so.
            if (getScore(playerHand) <= 21) {
               System.out.println("You draw " 
                  + playerHand.get((playerHand.size() - 1)) + "\n");
               System.out.print("You are currently at " 
                  + getScore(playerHand) + "\nwith the hand ");
               System.out.println(printHand(playerHand));
               System.out.print("Hit or stay?(Hit = 1, Stay = 0) ");
               hit = scanner.nextInt();
               System.out.println(hit);   
            }
         }
         
      //If game is still going then program deals to the dealer.
         if (getScore(playerHand) <= 21) {
            System.out.print("\nDealer is at " + getScore(dealerHand) 
               + "\nwith the hand ");
            System.out.println(printHand(dealerHand));
            for (int i = 0; getScore(dealerHand) < 17; i++) { //Step thru
               dealerHand.add(deck.deal());
               System.out.println("Dealer draws "
                  + dealerHand.get((dealerHand.size() - 1)) + "\n");
               if (getScore(dealerHand) <= 17) {
                  System.out.print("Dealer is at " + getScore(dealerHand)
                     + "\nwith the hand ");
                  System.out.println(printHand(dealerHand));
               }
            }
         }
         // Checks to see if the player beat the dealer.
         if ((getScore(playerHand) > getScore(dealerHand)) && !playerBust) {
            System.out.println("You beat the dealer!");
            loop = true;
         }
         // Checks to see if the dealer bust.
         else if (getScore(dealerHand) > 21) {
            System.out.println("You beat the dealer!");
            dealerBust = true;
         }
         // Checks to see if there was a tie.   
         else if (getScore(playerHand) == getScore(dealerHand)) {
            System.out.println("You tied the dealer. The dealer wins.");
            loop = true;
         }
         // Checks to see if the dealer won.
         else if (getScore(playerHand) < getScore(dealerHand) 
            && getScore(dealerHand) <= 21) {
            System.out.println("Dealer wins!");
            loop = true;
         }
      }
   }
  /**
   * A method to get the score for the dealer and the player.
   * @param cards an arraylist that holds the cards in a hand.
   * @return result: the outcome of the method AKA the score
   */
   public static int getScore(ArrayList<Card> cards) {
      int result = 0;
      for (Card newCard : cards) {
         result += newCard.pointValue();
      }
      for (Card newCard : cards) {
         if (newCard.rank().equals("ACE") && result > 21) {
            result -= 10;
         }
      }
      
      return result;
   }
   /** 
    * A method to dump the hands in a print statement.
    * @param cards an arraylist that holds the cards in a hand.
    * @return hand1 for the method.
    */
    
   public static String printHand(ArrayList<Card> cards) {
      String hand = "";
      if (cards.size() != 0) {
         System.out.print("[");
      
         for (int i = 0; i < cards.size() - 1; i++) {
            System.out.print("['" + (cards.get(i)).rank() + "','" 
               + (cards.get(i)).suit() + "'],");
         }
         
         System.out.println("['" 
            + (cards.get(cards.size() - 1)).rank() + "','" 
            + (cards.get(cards.size() - 1)).suit() + "']" + "]");
      }
      
     
      return hand;        
   }
}