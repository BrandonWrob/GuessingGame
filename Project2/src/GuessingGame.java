import java.util.Random;
import java.util.Scanner;

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
    
        //prompts user with instructions of the game
        System.out.printf("%44s%n" ,"Welcome to the Guessing Game!");
        System.out.println("You must try to guess a secret code consisting of 4 digits.");
        System.out.println("After each guess,  the total number of correct digits (CD)");
        System.out.println("and the number of correct digits in the correct place (CP)");
        System.out.println("for the guess and all preceding guesses will be output. You");
        System.out.println("will have 10 chances to guess the secret code, which will");
        System.out.println("be revealed, if you do not guess it!");
        System.out.println("");
    
        //creates scanner named userInput, prompts user to
        //input 4 digits, stores value in a string
        Scanner userInput = new Scanner(System.in);
        System.out.print("Guess 4 digits (e.g., 2 8 5 8): ");
        String fourDigitInput = userInput.nextLine();

        //confirms users input is a valid guess, 
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
     * @throws IllegalArgumentException with message "Null rand" if rand
     * equals null
     * @throws IllegalArgumentException with message "Invalid length"
     * if length is less than one
    */
    public static int[] getSecretCode(Random rand, int length) {
        if (rand == null) {
            throw new IllegalArgumentException("Null rand");
        }
        if (length < 1) {
            throw new IllegalArgumentException("Invalid length");
        }
        
        return null; 
                             
    }

    /**
    * method tells user how many correct digits they guessed
    * @param code stores the secret code
    * @param guess stores the users guess of the code.
    * @return how many digits are correct
    * @throws IllegalArgumentException with the messge, "Null code"
    * if code is null
    * @throws IllegalArgumentException with the message, "Null guess",
    * if guess is null.
    * @throws IllegalArgumentException with the message, "Different lengths",
    * if the lengths of the code and guess are arrays are different.
    * @throws IllegalArgumentException with the message, "Invalid digit",
    * if the code or guess array contains an integer that is less than 0
    * or greater than 9.
    */
    public static int getCorrectDigits(int[] code, int[] guess) {
        final int maxIntValue = 9;
        final int smallestIntValue = 0;
        //throws illegal argument exception if code or guess
        //code is null
        if (code == null) {
            throw new IllegalArgumentException("Null code");
        }
        else if (guess == null) {
            throw new IllegalArgumentException("Null guess");
        }
        //throws illegal argument exception if different lengths
        if (code.length != guess.length) {
            throw new IllegalArgumentException("Different lengths");
        }
        //throws illegal argument exception if code or guess
        //have a value less than 0 or greater than 9
        for (int i = 0; i < code.length; i++) {
            if (code[i] < smallestIntValue || code[i] > maxIntValue) {
                throw new IllegalArgumentException("Invalid digit");
            }
        }
        for (int n = 0; n < guess.length; n++) {
            if (guess[n] < smallestIntValue || guess[n] > maxIntValue) {
                throw new IllegalArgumentException("Invalid digit");
            }
        }
        //creates a int to store count of correct values
        int count = 0;
        //uses for loop to traverse through guess array characters
        //storing value in a temporary int
        for (int g = 0; g < guess.length; g++) {
            int tempInt = guess[g];
            //uses a nested for loop to traverse through code array
            //if a element equals tempInt it will change the value so
            //it cannot be used again, add one to the count int,
            //then leave the inner for loop with a break
            for (int c = 0; c < code.length; c++) {
                if (tempInt == code[c]) {
                    count ++;
                    code[c] = -1;
                    break;
                }
            }
        }
        //returns count value
        return count;

    }

    /** 
    * method tells user how many of their digits are in correct place
    * @param code stores the secret code
    * @param guess stores the users guess of the code
    * @return number of digits in correct position in array
    * @throws IllegalArgumentException with the messge, "Null code"
    * if code is null
    * @throws IllegalArgumentException with the message, "Null guess",
    * if guess is null.
    * @throws IllegalArgumentException with the message, "Different lengths",
    * if the lengths of the code and guess are arrays are different.
    * @throws IllegalArgumentException with the message, "Invalid digit",
    * if the code or guess array contains an integer that is less than 0
    * or greater than 9.
    */
    public static int getCorrectDigitsInCorrectPlace(int[] code, int[] guess) {
        final int maxIntValue = 9;
        final int smallestIntValue = 0;
        //throws illegal argument exception if code or guess
        //code is null
        if (code == null) {
            throw new IllegalArgumentException("Null code");
        }
        else if (guess == null) {
            throw new IllegalArgumentException("Null guess");
        }
        //throws illegal argument exception if different lengths
        if (code.length != guess.length) {
            throw new IllegalArgumentException("Different lengths");
        }
        //throws illegal argument exception if code or guess
        //have a value less than 0 or greater than 9
        for (int i = 0; i < code.length; i++) {
            if (code[i] < smallestIntValue || code[i] > maxIntValue) {
                throw new IllegalArgumentException("Invalid digit");
            }
        }
        for (int n = 0; n < guess.length; n++) {
            if (guess[n] < smallestIntValue || guess[n] > maxIntValue) {
                throw new IllegalArgumentException("Invalid digit");
            }
        }
        //creates variable to count number of digits in correct spot
        int count = 0;
        //uses for loop to traverse through guess array characters
        //checks code and guess array at each index to see if they
        //are equal, if they are it adds one to count
        for (int g = 0; g < guess.length; g++) {
            if (code[g] == guess[g]) {
                count ++;
            }
        }
        //returns count value
        return count;
    }

}