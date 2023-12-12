/*
* Programmer: Rion Seekings
* Title: Shuffler class
* Date: Dec 5, 2022
* Desc: Make a class that is able to execute two different types of shuffles.
* Class: CompSci-AP MWF 10:00 a.m.
*/
import java.lang.Math;

/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

    /**
     * The number of consecutive shuffle steps to be performed in each call
     * to each sorting procedure.
     */
   private static final int SHUFFLE_COUNT = 5;

    /**
     * The number of values to shuffle.
     */
   private static final int VALUE_COUNT = 10;

    /**
     * Tests shuffling methods.
     * @param args is not used.
     */
   public static void main(String[] args) {
      System.out.println("Results of " + SHUFFLE_COUNT +
                                 " consecutive perfect shuffles:");
      int[] values1 = new int[VALUE_COUNT];
      for (int i = 0; i < values1.length; i++) {
         values1[i] = i;
      }
      for (int j = 1; j <= SHUFFLE_COUNT; j++) {
         perfectShuffle(values1);
         System.out.print("  " + j + ":");
         for (int k = 0; k < values1.length; k++) {
            System.out.printf(" %2d", values1[k]);
         }
         System.out.println();
      }
      System.out.println();
   
      System.out.println("Results of " + SHUFFLE_COUNT +
                                 " consecutive efficient selection shuffles:");
      int[] values2 = new int[VALUE_COUNT];
      for (int i = 0; i < values2.length; i++) {
         values2[i] = i;
      }
      for (int j = 1; j <= SHUFFLE_COUNT; j++) {
         selectionShuffle(values2);
         System.out.print("  " + j + ":");
         for (int k = 0; k < values2.length; k++) {
            System.out.printf(" %2d", values2[k]);
         }
         System.out.println();
      }
      System.out.println();
   }


    /**
     * Apply a "perfect shuffle" to the argument.
     * The perfect shuffle algorithm splits the deck in half, then interleaves
     * the cards in one half with the cards in the other.
     * @param values is an array of integers simulating cards to be shuffled.
     */
   public static void perfectShuffle(int[] values) {
   
      int[] temp = new int[values.length];
      int mid = values.length / 2; //make a midpoint of deck to easily make 2 halves of deck
      int evenShelf = 0; //start at zero so every two slots is an even slot
   
      for (int i = 0; i < mid; i++) //step thru all cards in first half
      {
         temp[evenShelf] = values[i]; //set values in unshuffled deck into new even slots of a temp deck
         evenShelf+=2;
      }
      
      int oddShelf = 1; //start at 1 so every 2 slots is an odd slot
      
      for (int i = mid; i < values.length;i++) //step thru all cards in second half
      {
         temp[oddShelf]= values[i]; //set values in unshuffled deck into new odd slots of a temp deck
         oddShelf+=2;
      }
      for (int i = 0; i < values.length; i++)
      {
         values[i] = temp[i]; //set temp deck with shuffled cards to the original deck
      }
     
   }

    /**
     * Apply an "efficient selection shuffle" to the argument.
     * The selection shuffle algorithm conceptually maintains two sequences
     * of cards: the selected cards (initially empty) and the not-yet-selected
     * cards (initially the entire deck). It repeatedly does the following until
     * all cards have been selected: randomly remove a card from those not yet
     * selected and add it to the selected cards.
     * An efficient version of this algorithm makes use of arrays to avoid
     * searching for an as-yet-unselected card.
     * @param values is an array of integers simulating cards to be shuffled.
     */
   public static void selectionShuffle(int[] values) {
   
      for (int lastPos = values.length-1; lastPos>0; lastPos--)
      {
         int pick = (int) (Math.random()*(lastPos+1)); //cast as int so random number doesn't go above length
         int temp = values[pick]; //Switch
         values[pick] = values[lastPos];
         values[lastPos] = temp;
      }
   
   }
}