import java.util.Random;
import java.util.Scanner;

public class BullsAndCowsGame {
    private int secretNumberLength;
    private String secretNumber;
    private int attemptsLeft;
    private boolean gameOver;

    public static void main(String[] args) {
        BullsAndCowsGame game = new BullsAndCowsGame();
        game.start();
    }

    public void start() {
        System.out.println("Welcome to Bulls and Cows!");
        System.out.println("The rules of the game are simple: you have to guess a secret number that the computer has chosen.");
        System.out.println("Each time you make a guess, the computer will tell you how many bulls and cows you have.");
        System.out.println("A bull means a correct digit in the correct position, while a cow means a correct digit in the wrong position.");
        System.out.println("You have a limited number of attempts to guess the secret number.");
        System.out.println("Good luck!\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the secret number (between 4 and 6): ");
        secretNumberLength = scanner.nextInt();

        generateSecretNumber();

        while (!gameOver) {
            System.out.println("\nEnter a " + secretNumberLength + "-digit number (you have " + attemptsLeft + " attempts left): ");
            String guess = scanner.next();

            if (guess.length() != secretNumberLength) {
                System.out.println("Please enter a " + secretNumberLength + "-digit number.");
                continue;
            }

            int bulls = 0;
            int cows = 0;
            for (int i = 0; i < secretNumberLength; i++) {
                char c = guess.charAt(i);
                if (c == secretNumber.charAt(i)) {
                    bulls++;
                } else if (secretNumber.indexOf(c) != -1) {
                    cows++;
                }
            }

            attemptsLeft--;
            if (bulls == secretNumberLength) {
                System.out.println("\nCongratulations, you win!");
                gameOver = true;
            } else if (attemptsLeft == 0) {
                System.out.println("\nGame over, you lose. The secret number was " + secretNumber + ".");
                gameOver = true;
            } else {
                System.out.println("Bulls: " + bulls + "  Cows: " + cows);
                if (bulls == 0 && cows == 0) {
                    System.out.println("Sorry, no bulls or cows this time. Try again.");
                } else {
                    System.out.println("You're getting closer! Try again.");
                }
            }
        }

        scanner.close();
    }

    private void generateSecretNumber() {
        Random random = new Random();
        boolean[] used = new boolean[10];
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < secretNumberLength; i++) {
            int digit;
            do {
                digit = random.nextInt(10);
            } while (used[digit]);
            used[digit] = true;
            builder.append(digit);
        }
        secretNumber = builder.toString();
        attemptsLeft = (int) (secretNumberLength * 1.5);
        gameOver = false;
    }
}
