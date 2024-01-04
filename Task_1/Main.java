//Number Game
package Task_1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int randomNumber = (int) (Math.random() * 100.0) + 1;
        Scanner scanner = new Scanner(System.in);
        boolean guessedCorrectly = false;
        int numberOfAttempts = 0;

        System.out.println("\nSystem Generated Number is " + randomNumber);

        while (!guessedCorrectly && numberOfAttempts < 3) {
            System.out.print("\nGuess a number between 1 and 100: \t");
            int userGuess = scanner.nextInt();

            if (userGuess == randomNumber) {
                guessedCorrectly = true;
            } else {
                ++numberOfAttempts;
                String result = (userGuess > randomNumber) ? "Your guess is too high." : "Your guess is too low.";
                System.out.println(result);
            }
        }

        scanner.close();
        if (guessedCorrectly) {
            System.out.println("\nCongratulations! You guessed correctly! The number was " + randomNumber);
        } else {
            System.out.println("\nSorry, you ran out of guesses. The correct answer was " + randomNumber);
        }

    }
}
