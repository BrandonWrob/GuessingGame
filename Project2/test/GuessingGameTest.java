import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.beans.Transient;
import java.util.*;

/**
 * Program to test GuessingGame methods
 * @author Suzanne Balik
 * @author Michelle Glatz 
 * @author Brandon N. Wroblewski
 */
public class GuessingGameTest {

    @Test
    public void testGetSecretCodeSeed1Length4() {
        int[] expected = {5, 8, 7, 3};
        Random rand = new Random();
        rand.setSeed(1);       
        assertArrayEquals(expected, GuessingGame.getSecretCode(rand, 4), 
                          "GuessingGame.getSecretCode(rand, 4)");
    }
    
    @Test
    public void testGetSecretCodeSeed1Length10() {
        int[] expected = {5, 8, 7, 3, 4, 4, 4, 6, 8, 8};
        Random rand = new Random();
        rand.setSeed(1);       
        assertArrayEquals(expected, GuessingGame.getSecretCode(rand, 10), 
                          "GuessingGame.getSecretCode(rand, 10)");
    } 

    
    @Test
    public void testGetSecretCodeSeed2Length2() {
        int[] expected = {8, 2};
        Random rand = new Random();
        rand.setSeed(2);       
        assertArrayEquals(expected, GuessingGame.getSecretCode(rand, 2), 
                          "GuessingGame.getSecretCode(rand, 2)");
    }      
    
    /**
     * checks the getCorrectDigits method where user guesses
     * one correct digit (out of 4)
     */
    @Test
    public void testGetCorrectDigits1Correct() {
        int[] code = {2, 3, 4, 5};
        int[] guess = {7, 4, 9, 8};
        assertEquals(1, GuessingGame.getCorrectDigits(code, guess));
    }
    
    /**
     * checks the getCorrectDigits method where user guesses
     * two correct digits (out of 4)
     */
    @Test
    public void testGetCorrectDigits2Correct() {
        int[] code = {2, 3, 4, 5};
        int[] guess = {7, 4, 2, 8};
        assertEquals(2, GuessingGame.getCorrectDigits(code, guess));
    } 

    /**
     * checks the getCorrectDigits method where user guesses
     * three correct digits (out of 4)
     */
    @Test
    public void testGetCorrectDigits3Correct() {
        int[] code = {2, 3, 4, 5};
        int[] guess = {5, 4, 2, 8};
        assertEquals(3, GuessingGame.getCorrectDigits(code, guess));
    }    
  
    /**
     * checks the getCorrectDigits method where user guesses
     * one correct digit (out of 2)
     */
    @Test
    public void testGetCorrectDigits1CorrectLength2() {
        int[] code = {2, 3};
        int[] guess = {7, 2};
        assertEquals(1, GuessingGame.getCorrectDigits(code, guess));
    }
    
    /**
     * checks the getCorrectDigits method where user guesses
     * four correct digits (out of 8)
     */
    @Test
    public void testGetCorrectDigits4CorrectLength8() {
        int[] code = {1, 2, 6, 9, 0, 5, 8, 4};
        int[] guess = {0, 5, 8, 7, 3, 5, 3, 4};
        assertEquals(4, GuessingGame.getCorrectDigits(code, guess));
    } 

    /**
     * checks the getCorrectDigits method where user guesses
     * three out of four correct digits while having 2 duplicate
     * values in code, 3 in guess of same value
     * (should only count duplicate twice)
     */
    @Test
    public void testGetCorrectDigits3CorrectDuplicatesInGuessAndCode() {
        int[] code = {1, 1, 2, 3};
        int[] guess = {2, 1, 1, 1};
        assertEquals(3, GuessingGame.getCorrectDigits(code, guess));
    }
    
    /**
     * checks the getCorrectDigits method where user guesses
     * two out of four correct digits while having 2 duplicate
     * values corresponding to 3 duplicate values in code
     * (should only count two of them)
     */
    @Test 
    public void testGetCorrectDigits2Correct2DuplicatesCode3DuplicatesInGuess() {
        int[] code = {4, 1, 1, 1};
        int[] guess = {1, 1, 2, 3};
        assertEquals(2, GuessingGame.getCorrectDigits(code, guess));
    }

    /**
     * checks the getCorrectDigit method where user
     * guesses all digits being correct
     */
    @Test 
    public void testGetCorrectDigitsAllCorrectGuesses() {
        int[] code = {4, 3, 3, 2};
        int[] guess = {2, 3, 4, 3};
        assertEquals(4, GuessingGame.getCorrectDigits(code, guess));
    }

    /**
     * checks the getCorrectDigit method where user
     * guesses none of the correct digits in code
     */
    @Test 
    public void testGetCorrectDigitsNoCorrectGuesses() {
        int[] code = {2, 3, 2, 3};
        int[] guess = {9, 4, 6, 5};
        assertEquals(0, GuessingGame.getCorrectDigits(code, guess));
    }

    /**
     * checks the getCorrectDigit method where users
     * guess has duplicate digits that match a code
     * digit, but code only has one of the digit
     */
    @Test 
    public void testGetCorrectDigitsDuplicateGuessSingularCode() {
        int[] code = {1, 2, 3, 4};
        int[] guess = {5, 5, 4, 4};
        assertEquals(1, GuessingGame.getCorrectDigits(code, guess));
    }

    /**
     * checks the getCorrectDigits method where user
     * guess has a singular digit that matches a digit
     * in code which is a duplicate
     */
    @Test 
    public void testGetCorrectDigitsSingularGuessDuplicateCodeValue() {
        int[] code = {1, 1, 2, 3};
        int[] guess = {2, 2, 5, 7};
    }
        
    /**
     * tests the getCorrectDigitsInCorrectPlace method
     * where 2 digits in guess are in correct place
     * out of 4 digits
     */
    @Test
    public void testGetCorrectDigitsInCorrectPlace2CorrectDigits1CorrectPlace() {
        int[] code = {2, 3, 4, 5};
        int[] guess = {2, 4, 6, 8};
        assertEquals(1, GuessingGame.getCorrectDigitsInCorrectPlace(code, guess));
    }
    
    /**
     * tests the getCorrectDigitsInCorrectPlace method
     * where 3 digits in guess are in correct place
     * out of 4 digits
     */
    @Test
    public void testGetCorrectDigitsInCorrectPlace3CorrectDigits3CorrectPlace() {
        int[] code = {2, 3, 4, 5};
        int[] guess = {2, 8, 4, 5};
        assertEquals(3, GuessingGame.getCorrectDigitsInCorrectPlace(code, guess));
    }
        
    /**
     * tests the getCorrectDigitsInCorrectPlace method
     * where 1 digit in guess is in correct place out
     * of 2 digits
     */
    @Test
    public void testGetCorrectDigitsInCorrectPlace1CorrectLength2() {
        int[] code = {0, 9};
        int[] guess = {1, 9};
        assertEquals(1, GuessingGame.getCorrectDigitsInCorrectPlace(code, guess));
    }    

    /**
     * tests the getCorrectDigitsInCorrectPlace method
     * where 4 digits in guess are in correct place
     * out of 6 digits
     */
    @Test
    public void testGetCorrectDigitsInCorrectPlace4CorrectLength6() {
        int[] code = {2, 3, 4, 5, 6, 0};
        int[] guess = {2, 3, 4, 9, 5, 0};
        assertEquals(4, GuessingGame.getCorrectDigitsInCorrectPlace(code, guess));
    }

    /**
     * tests the getCorrectDigitsInCorrectPlace method
     * where all digits are in the correct place
     */
    @Test
    public void testGetCorrectDigitsInCorrectPlaceAllCorrectLength6() {
        int[] code = {2, 3, 4, 5, 6, 0};
        int[] guess = {2, 3, 4, 5, 6, 0};
        assertEquals(6, GuessingGame.getCorrectDigitsInCorrectPlace(code, guess));
    }

    /**
     * tests the getCorrectDigitsInCorrectPlace method
     * where no digits are in the correct place, but
     * they both have same digits
     */
    @Test
    public void testGetCorrectDigitsInCorrectPlaceNoneCorrectPlaceLength6() {
        int[] code = {2, 3, 4, 5, 6, 0};
        int[] guess = {3, 2, 5, 4, 0, 6};
        assertEquals(0, GuessingGame.getCorrectDigitsInCorrectPlace(code, guess));
    }
    
    /**
     * tests the getCorrectDigitsInCorrectPlace method
     * where two digits are in the correct place, and 
     * guess has all the correct digits
     */
    @Test
    public void testGetCorrectDigitsInCorrectPlaceTwoCorrectPlaceLength6() {
        int[] code = {2, 3, 4, 5, 6, 0};
        int[] guess = {2, 3, 5, 4, 0, 6};
        assertEquals(2, GuessingGame.getCorrectDigitsInCorrectPlace(code, guess));
    }

    /**
     * tests the getCorrectDigitsInCorrectPlace method
     * where three digits are in the correct place, and
     * they both have same digits
     */
    @Test
    public void testGetCorrectDigitsInCorrectPlaceThreeCorrectPlaceLength6() {
        int[] code = {2, 3, 4, 5, 6, 0};
        int[] guess = {2, 3, 4, 0, 5, 6};
        assertEquals(3, GuessingGame.getCorrectDigitsInCorrectPlace(code, guess));
    }

    /**
     * Test the GuessingGame methods with invalid values
     */
    @Test
    public void testInvalidMethods() {

        // Invalid test cases are provided for you below - You do NOT
        // need to add additional invalid tests. Just make sure these
        // pass!


        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> GuessingGame.getSecretCode(null, 4),
                                 "GuessingGame.getSecretCode(null, 4)");
        assertEquals("Null rand", exception.getMessage(),
                     "Testing GuessingGame.getSecretCode(null, 4) - " +
                     "exception message when rand is null");
        
        exception = assertThrows(IllegalArgumentException.class,
            () -> GuessingGame.getSecretCode(null, 0),
                                 "GuessingGame.getSecretCode(null, 0)");
        assertEquals("Null rand", exception.getMessage(),
                     "Testing GuessingGame.getSecretCode(null, 0) - " +
                     "exception message when rand is null and length < 1");
                     
        Random rand = new Random();
        rand.setSeed(1);        
                     
        exception = assertThrows(IllegalArgumentException.class,
            () -> GuessingGame.getSecretCode(rand, 0),
                                 "GuessingGame.getSecretCode(rand, 0)");
        assertEquals("Invalid length", exception.getMessage(),
                     "Testing GuessingGame.getSecretCode(rand, 0) - " +
                     "exception message when length < 1");
                    
        int[] guess = new int[4];                    
        exception = assertThrows(IllegalArgumentException.class,
            () -> GuessingGame.getCorrectDigits(null, guess),
                                 "GuessingGame.getCorrectDigits(null, guess)");
        assertEquals("Null code", exception.getMessage(),
                     "Testing GuessingGame.getCorrectDigits(null, guess) - " +
                     "exception message with null code"); 

        exception = assertThrows(IllegalArgumentException.class,
            () -> GuessingGame.getCorrectDigitsInCorrectPlace(null, guess),
                                 "GuessingGame.getCorrectDigitsInCorrectPlace(null, guess)");
        assertEquals("Null code", exception.getMessage(),
                     "Testing GuessingGame.getCorrectDigitsInCorrectPlace(null, guess) - " +
                     "exception message with null code");                      
        
        exception = assertThrows(IllegalArgumentException.class,
            () -> GuessingGame.getCorrectDigits(null, null),
                                 "GuessingGame.getCorrectDigits(null, null)");
        assertEquals("Null code", exception.getMessage(),
                     "Testing GuessingGame.getCorrectDigits(null, null) - " +
                     "exception message with null code and null guess"); 
 
        exception = assertThrows(IllegalArgumentException.class,
            () -> GuessingGame.getCorrectDigitsInCorrectPlace(null, null),
                                 "GuessingGame.getCorrectDigitsInCorrectPlace(null, null)");
        assertEquals("Null code", exception.getMessage(),
                     "Testing GuessingGame.getCorrectDigitsInCorrectPlace(null, null) - " +
                     "exception message with null code and null guess"); 
 
        int[] code = new int[5];      
        exception = assertThrows(IllegalArgumentException.class,
            () -> GuessingGame.getCorrectDigits(code, null),
                                 "GuessingGame.getCorrectDigits(code, null)");
        assertEquals("Null guess", exception.getMessage(),
                     "Testing GuessingGame.getCorrectDigits(code, null) - " +
                     "exception message with null guess"); 
                     
        exception = assertThrows(IllegalArgumentException.class,
            () -> GuessingGame.getCorrectDigitsInCorrectPlace(code, null),
                                 "GuessingGame.getCorrectDigitsInCorrectPlace(code, null)");
        assertEquals("Null guess", exception.getMessage(),
                     "Testing GuessingGame.getCorrectDigitsInCorrectPlace(code, null) - " +
                     "exception message with null guess");                      
        
        exception = assertThrows(IllegalArgumentException.class,
            () -> GuessingGame.getCorrectDigits(code, guess),
                                 "GuessingGame.getCorrectDigits(code, guess)");
        assertEquals("Different lengths", exception.getMessage(),
                     "Testing GuessingGame.getCorrectDigits(code, guess) - " +
                     "exception message with different lengths"); 

        exception = assertThrows(IllegalArgumentException.class,
            () -> GuessingGame.getCorrectDigitsInCorrectPlace(code, guess),
                                 "GuessingGame.getCorrectDigitsInCorrectPlace(code, guess)");
        assertEquals("Different lengths", exception.getMessage(),
                     "Testing GuessingGame.getCorrectDigitsInCorrectPlace(code, guess) - " +
                     "exception message with different lengths"); 

        int[] code1 = {1, 2, 10, 5};
        int[] guess1 = {1, 2, 9, 5}; 

        exception = assertThrows(IllegalArgumentException.class,
            () -> GuessingGame.getCorrectDigits(code1, guess1),
                                 "GuessingGame.getCorrectDigits(code1, guess1)");
        assertEquals("Invalid digit", exception.getMessage(),
                     "Testing GuessingGame.getCorrectDigits(code1, guess1) - " +
                     "exception message with 10 as a code digit"); 

        exception = assertThrows(IllegalArgumentException.class,
            () -> GuessingGame.getCorrectDigitsInCorrectPlace(code1, guess1),
                                 "GuessingGame.getCorrectDigitsInCorrectPlace(code1, guess1)");
        assertEquals("Invalid digit", exception.getMessage(),
                     "Testing GuessingGame.getCorrectDigitsInCorrectPlace(code1, guess1) - " +
                     "exception message with 10 as a code digit"); 
 
        int[] code3 = {1, 2, 8, 5};
        int[] guess3 = {1, -1, 9, 5}; 

        exception = assertThrows(IllegalArgumentException.class,
            () -> GuessingGame.getCorrectDigits(code3, guess3),
                                 "GuessingGame.getCorrectDigits(code3, guess3)");
        assertEquals("Invalid digit", exception.getMessage(),
                     "Testing GuessingGame.getCorrectDigits(code3, guess3) - " +
                     "exception message with -1 as a guess digit"); 

        exception = assertThrows(IllegalArgumentException.class,
            () -> GuessingGame.getCorrectDigitsInCorrectPlace(code3, guess3),
                                 "GuessingGame.getCorrectDigitsInCorrectPlace(code3, guess3)");
        assertEquals("Invalid digit", exception.getMessage(),
                     "Testing GuessingGame.getCorrectDigitsInCorrectPlace(code3, guess3) - " +
                     "exception message with -1 as a guess digit"); 
         
                                     
    }
}
