import java.util.Random;

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
     * method generates a secret code
     * @param rand instance is used to generate digits between 0 and 9
     * @param length stores given length 
     * Throws an IllegalArgumentException with the message, "Null rand",
     * if rand is null
     * Throws an IllegalArgumentException with the message, "Invalid length",
     * if length < 1
     * @return int array of secret code
    */
    public static int[] getSecretCode(Random rand, int length) {
        return null; 
                             
    }

    /**
    * method tells user how many correct digits they guessed
    * @param code stores the secret code
    * @param guess stores the users guess of the code
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
    * method tells user how many of their digits are in correct place
    * @param code stores the secret code
    * @param guess stores the users guess of the code
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