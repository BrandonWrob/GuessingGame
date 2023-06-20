# csc116-051-P2-02

Name: [Brandon N. Wroblewski]
6/15/2023:
-created .gitignore, academic integrity contract, readme file
-added project folders holding src/GuessingGame.java , bin/GuessingGame.class and GuessingGameTest.class,
lib with respectful file, test/GuessingGame.java, and project_docs holding a empty pdf (for process points)

6/16/2023
-modified main method
[added instruction prompt]
-modified getSecretCode method
[added illegal argument exceptions for null random and invalid length]
-modified getCorrectDigits method
[added illegal argument exceptions for null code, null guess, different length arrays, and invalid digits. Created a int to store count and used a for loop to traverse through users guess storing the values in array in a temporary int. Then a nested for loop inside would go through the code array, if a value matched the temporary int it would add 1 to the counter, change the code array value to -1 so it can't be reused in case of duplicates in guess/code, and uses a break to end the inner for loop to go back to the outer one. Then I added a return count method at end to return correct number of digits]
-modified getCorrectDigitsInCorrectPlace method 
[where I added illegal argument exceptions if given node arrays, arrays of unequal length, or arrays with an invalid value (less than 0 or greater than 9). I also added a for loop which traversed through the length of the arrays checking each element of both arrays to see if any of them equal at the same index, if they did I would add one to a int named counter which would store the total value of digits in the correct place. At the end I added a return count; to return the value to main.
-modified GuessingGameTest by adding test cases for the getCorrectDigits and getCorrectDigitsInCorrectPlace method]

6/17/2023
-modified getSecretCode method
[Added a int array named secretCode (with a length equal to length parameter), then I added a for loop to traverse through the length of it, and at each element it uses the rand.nextInt(10) to assign a random value between 0 and 9, then I added a return to send the secret code to main]

6/18/2023 - 6/19/2023
-modified main
[added initial prompt with instructions on how the game would work, added code to implement seed values for secret code, created a int value called code to hold the secret code, and had it call upon the getSecretCode method with a rand value and length of 4, created an array to hold users guesses and store them with other info, created a String named guessString which holds 4 values, created a while statement which would prompt user for a guess, collect the info, if it was invalid reprompt them, if valid check if the values are correct, and return current and previous guesses with correct amount of digits and places. If they guessed all correct digits in right place the while loop would end and tell them how many guesses it took, if it reached 10 it would end and print the correct code. ]