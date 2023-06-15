import java.util.Random;
import  java.util.Scanner;
/**
 * Program runs a game with user where they try to guess a code
 * and the game returns how many correct numbers guessed and
 * how many are in the correct spot
 * @author Brandon N. Wroblewski
 */
public class GuessingGame {
    /**
     * starts program
     * @param args command line argument
     */
    public static void main(String[] args) {

    }

    /** 
     * This method creates and returns an integer array of the given length.
     * The rand instance is used to generate digits between 0 and 9
     * Throws an IllegalArgumentException with the message, "Null rand",
     * if rand is null
     * Throws an IllegalArgumentException with the message, "Invalid length",
     * if length < 1
     * @return int array of secret code
    */
    public static int[] getSecretCode(Random rand, int length) {
        return null; 
                             
    }

    /**Returns the number of digits in the guess array that are also in
    * the code array.
    * Throws an IllegalArgumentException with the message, "Null code",
    * if code is null.
    * Throws an IllegalArgumentException with the message, "Null guess",
    * if guess is null.
    * Throw an IllegalArgumentException with the message, "Different lengths",
    * if the lengths of the code and guess are arrays are different.
    * Throws an IllegalArgumentException with the message, "Invalid digit",
    * if the code or guess array contains an integer that is less than 0
    * or greater than 9.
    * @return how many digits are correct
    */
    public static int getCorrectDigits(int[] code, int[] guess) {
        return 0;

    }

    /** 
    * Returns the number of digits in the guess array that are in the same 
    * position in the code array. 
    * Throws an IllegalArgumentException with the message, "Null code",
    * if code is null.
    * Throws an IllegalArgumentException with the message, "Null guess",
    * if guess is null
    * Throws an IllegalArgumentException with the message, "Different lengths",
    * if the lengths of the code and guess are arrays are different.
    * Throws an IllegalArgumentException with the message, "Invalid digit",
    * if the code or guess array contains an integer that is less than 0
    * or greater than 9.
    * @return number of digits in correct position in array
    */
    public static int getCorrectDigitsInCorrectPlace(int[] code, int[] guess) {
        return 0;

    }

}