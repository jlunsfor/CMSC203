/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: This is a random number guessing game.
 * Due: 27 Feb 2023
 * Platform/compiler: Eclipse 22-12
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Jeremy Lunsford
*/


import java.util.Scanner;


public class RandomNumberGuesser {

	public static void main(String[] args) {
		// Declare vars
		int ans, guess;
		boolean correctGuessFlag = false,
				completeFlag = false,
				validInput;
		int lowRange = 0,
				highRange = 100;
		String replay;
		Scanner stdin = new Scanner(System.in);
		
		// Introduction
		System.out.println("This application generates a random integer between " + lowRange + " and "  
				+ highRange + " and asks the user to guess repeatedly until they guess correctly.\n");
		
		// Generate random
		ans = RNG.rand();
		
		while ((correctGuessFlag == false) && (completeFlag == false) && (RNG.getCount() < 7)) {
			/* Start debugging 
			System.out.println("**Start debugging**");
			System.out.println("Random is " + ans);
			System.out.println("low is " + lowRange);
			System.out.println("high is " + highRange);
			System.out.println("CompleteFlag is " + completeFlag);
			System.out.println("correct flag is " + correctGuessFlag);
			System.out.println("**End debugging**\n"); 
			// End debugging */
		
			// Request the guess and validate
			System.out.println("\nEnter your guess between " + lowRange + " and " + highRange);
			guess = Integer.parseInt(stdin.nextLine());			// This prevents problems when asking for restart
			validInput = RNG.inputValidation(guess, lowRange, highRange);
						
			// Check input validation and answer
			if (validInput == false) {}
			else {
				if (guess == ans) {
					System.out.println("Congratulations, you guessed correctly.\n");
					correctGuessFlag = true;
				}
				if (guess < ans) {
					System.out.println("Your guess is too low.");
					lowRange = guess;
					guess = -1;
				}
				if (guess > ans) {
					System.out.println("Your guess is too high.");
					highRange = guess;
					guess = -1;
				}
			}
			
			// Output guess number
			System.out.println("Number of guesses is: " + RNG.getCount() + ".\n");
			
			// Repeat handler
			if ((RNG.getCount() == 7) || (correctGuessFlag == true)) {
				/* Start debugging 
				System.out.println("**Start debugging**");
				System.out.println("Random is " + ans);
				System.out.println("low is " + lowRange);
				System.out.println("high is " + highRange);
				System.out.println("CompleteFlag is " + completeFlag);
				System.out.println("correct flag is " + correctGuessFlag);
				System.out.println("**End debugging**\n"); 
				// End debugging */
				if (correctGuessFlag == false) {
					System.out.println("You have exceeded the maximum number of guesses.");
				}
				System.out.println("Try again? (yes or no)");
				replay = stdin.nextLine();
				if (replay.toLowerCase().matches("no")) {
					completeFlag = true;
				}
				else {
					// Reset variables
					RNG.resetCount();
					correctGuessFlag = false;
					ans = RNG.rand();
					guess = -1;
					lowRange = 0;
					highRange = 100;
					replay = "";
				}
			}
		}
		
		System.out.print("Thanks for playing.");
	}
}
