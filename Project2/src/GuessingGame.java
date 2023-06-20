import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;


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
     * method creates a random number generate
     * method calls upon the getSecretCode method, the
     * getCorrectDigit method, and the getCorrectDigitsInCorrectPlace
     * method to display information of correct digits, places of users
     * guess, and display if they win (and how many guesses it took), or
     * if they lost (and reveal the secret code).
     */
    public static void main(String[] args) {
   
        //constants for magic numbers
        final int MAXLENGTH = 1;
        final int MINVALUE = 0;
        final int MAXVALUE = 9;
        final int ELEMENTSINGUESS = 4;
        final int MAXLOOP = 10;
        final int RETURNCOLUMNS = 9;

        //creates variable rand which utilizes random class
        //allowing it to generate random numbers
        Random rand = new Random();


        //If there is one argument in command line, this converts it
        //from a string to a int, and uses it as a seed, if argument
        //cannot be converted into a seed it will throw a NumberFormatException
        //(code is given from project instructions)
        if (args.length == MAXLENGTH) {
            try {
                int seed = Integer.parseInt(args[MINVALUE]);
                rand.setSeed(seed);
            }
            catch (NumberFormatException e) {
                System.out.println("Usage: java -cp bin GuessingGame <seed>");
                System.exit(1);
            }
        }
        //exits program if user gives too many arguments in command line
        if (args.length > MAXLENGTH) {
            System.exit(1);
        }

        //prompts user with instructions of the game
        System.out.printf("%44s%n" ,"Welcome to the Guessing Game!");
        System.out.println("You must try to guess a secret code consisting of 4 digits.");
        System.out.println("After each guess,  the total number of correct digits (CD)");
        System.out.println("and the number of correct digits in the correct place (CP)");
        System.out.println("for the guess and all preceding guesses will be output. You");
        System.out.println("will have 10 chances to guess the secret code, which will");
        System.out.println("be revealed, if you do not guess it!");
        System.out.println("");


        //creates int code which stores getSecretCode input with a length of 4
        //creates int variables to store how many values are in correct place of
        //guess, and what loop the while statement is in, also creates a String
        //array named return Array to store previous and current guesses from user,
        //and a String array that only holds users current guess named guessString
        int[] code = getSecretCode(rand, ELEMENTSINGUESS);
        int correctPlace = MINVALUE;
        int loop = MINVALUE;
        String[][] returnArray = new String[MAXLOOP][RETURNCOLUMNS];
        String[] guessString = new String[ELEMENTSINGUESS];


        //creates a outerloop statement to be called if a invalid guess is given
        //and we need to go back to the start of while loop
        outerloop:
        //while loop will continue until it loops 10 times, or if user guesses all
        //correct digits in the correct place
        while (loop < MAXLOOP) {
            //creates scanner named userInput, prompts user to
            //input 4 digits, stores value in a string
            System.out.println(" ");
            System.out.print("Guess 4 digits (e.g., 2 8 5 8): ");
            Scanner userInput = new Scanner(System.in);
            for (int i = MINVALUE; i < ELEMENTSINGUESS; i++) {
                guessString[i] = userInput.next();
                //confirms user does not give a value over one character long
                //if they do it will restart the while loop and display Invalid guess
                if(guessString[i].length() != MAXLENGTH) {
                    System.out.println("Invalid guess");
                    continue outerloop;
                }
            }
            //converts string array into char array
            char[] guessChar = new char[ELEMENTSINGUESS];
            //traverses through char array with for loop
            for (int c = MINVALUE; c < ELEMENTSINGUESS; c++) {
                guessChar[c] = guessString[c].charAt(MINVALUE);
                //checks if each char is a digit
                if(Character.isDigit(guessChar[c])) {
                    int temp = Character.getNumericValue(guessChar[c]);
                    //confirms each digit is a valid value
                    if (temp < MINVALUE || temp > MAXVALUE) {
                        //if it isn't, displays Invalid guess, goes to start of while loop
                        System.out.println("Invalid guess");
                        continue outerloop;
                    }
                }
                else {
                    //if not a digit, says invalid guess and goes to start of while loop
                    System.out.println("Invalid guess");
                    continue outerloop;
                }
            }

            //creates a int array named guess to store valid guesses
            int[] guess = new int[ELEMENTSINGUESS];
            for(int i = 0; i < guessString.length; i++) {
                guess[i] = Integer.parseInt(guessString[i]);
            }

            //calles upon getCorrectDigits method, stores value in a int
            int correctNumValues = getCorrectDigits(code, guess);


            //updates correctPlace int with value of getCorrectDigitsInCorrectPlace
            //method
            correctPlace = getCorrectDigitsInCorrectPlace(code, guess);
           
            //creates temporary string variables to hold guess information
            String first = guessString[0];
            String second = guessString[1];
            String third = guessString[2];
            String fourth = guessString[3];
            String valuesC = Integer.toString(correctNumValues);
            String placeC = Integer.toString(correctPlace);

            //updates returnArray with the guess information
            //creates constants for return values
            final int FIRSTINT = 0;
            final int SECONDINT = 1;
            final int THIRDINT = 2;
            final int FOURTHINT = 3;
            final int SEPERATOR = 4;
            final int CORRECTVALUES = 5;
            final int CORRECTPLACES = 6;
            returnArray[loop][FIRSTINT] = first;
            returnArray[loop][SECONDINT] = second;
            returnArray[loop][THIRDINT] = third;
            returnArray[loop][FOURTHINT] = fourth;
            returnArray[loop][SEPERATOR] = "| ";
            returnArray[loop][CORRECTVALUES] = valuesC + " ";
            returnArray[loop][CORRECTPLACES] = placeC;
            loop++;


            //prints out guess and correct value information
            System.out.println(" ");
            System.out.println(" Guess  | CD CP");
            for (int i = MINVALUE; i < returnArray.length; i++) {
                boolean rowHasValue = false;
                for (int j = MINVALUE; j < returnArray[i].length; j++) {
                    if (returnArray[i][j] != null) {
                        System.out.print(returnArray[i][j] + " ");
                        rowHasValue = true;
                    }
                }
                if (rowHasValue) {
                    System.out.println();
                }
            }
            //if user guessed all values correctly in correct place, it tells them
            //how many guesses it took
            if (correctPlace == code.length) {
                System.out.println(" ");
                System.out.println("You guessed correctly after " + loop + " guess(es)!");
                System.exit(0);
            }
        }
        //if user fails to guess the secret code in 10 gesses it tells them the code
        String codePrint = "";
        for (int c = MINVALUE; c < code.length; c++) {
            if(codePrint.equals("")) {
                codePrint = String.valueOf(code[c]);
            }
            else {
                codePrint = codePrint + " " + String.valueOf(code[c]);
            }
        }
        System.out.println(" ");
        System.out.print("Sorry, no more guesses - the secret code is ");
        for(int i = MINVALUE; i < code.length; i++) {
            System.out.print(code[i] + " ");
        }
        System.out.print("");
    }

    /**
     * method generates a secret code
     * @param rand instance is used to generate digits between 0 and 9
     * @param length stores given length
     * @return int array of secret code
     * @throws IllegalArgumentException with message "Null rand" if rand
     * equals null
     * @throws IllegalArgumentException with message "Invalid length"
     * if length is less than one
    */
    public static int[] getSecretCode(Random rand, int length) {
        //throws illegal argument exception if rand is null or
        //length is smaller than 1
        if (rand == null) {
            throw new IllegalArgumentException("Null rand");
        }
        if (length < 1) {
            throw new IllegalArgumentException("Invalid length");
        }
        //creates an int array to store secret code
        int[] secretCode = new int[length];
        //creates a for statement to traverse through the length
        //of secret code, at each element it sets the value
        //equal to a random integer between 0-9
        for (int i = 0; i < length; i ++) {
            secretCode[i] = rand.nextInt(10);
        }
        //returns the secret code
        return secretCode;
                             
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
        //throws illegal argument exception if code or guess
        //code is null
        if (code == null) {
            throw new IllegalArgumentException("Null code");
        }
        if (guess == null) {
            throw new IllegalArgumentException("Null guess");
        }
        int[] original = Arrays.copyOf(code, code.length);
        final int maxIntValue = 9;
        final int smallestIntValue = 0;
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


        //reverts code back to its original array
        for (int i = 0; i < code.length; i++) {
            code[i] = original[i];
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


