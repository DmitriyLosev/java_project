import java.util.Random;
import java.util.Scanner;

public class BullsAndCowsGame {
    private static final int SECRET_NUMBER_LENGTH = 4;
    private String secretNumber;

    public static void main(String[] args) {
        BullsAndCowsGame game = new BullsAndCowsGame();
        game.start();
    }

    public void start() {
        generateSecretNumber();
        Scanner scanner = new Scanner(System.in);
        int attemptsLeft = 10;
        while (true) {
            System.out.println("Enter a " + SECRET_NUMBER_LENGTH + "-digit number (you have " + attemptsLeft + " attempts left):");
            String guess = scanner.next();
            if (guess.length() != SECRET_NUMBER_LENGTH) {
                System.out.println("Please enter a " + SECRET_NUMBER_LENGTH + "-digit number.");
                continue;
            }
            int bulls = 0;
            int cows = 0;
            for (int i = 0; i < SECRET_NUMBER_LENGTH; i++) {
                char c = guess.charAt(i);
                if (c == secretNumber.charAt(i)) {
                    bulls++;
                } else if (secretNumber.indexOf(c) != -1) {
                    cows++;
                }
            }
            attemptsLeft--;
            if (bulls == SECRET_NUMBER_LENGTH) {
                System.out.println("You win!");
                break;
            } else if (attemptsLeft == 0) {
                System.out.println("You lose. The secret number was " + secretNumber + ".");
                break;
            } else {
                System.out.println(bulls + " bull(s) and " + cows + " cow(s). Try again.");
            }
        }
    }

    private void generateSecretNumber() {
        Random random = new Random();
        boolean[] used = new boolean[10];
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < SECRET_NUMBER_LENGTH; i++) {
            int digit;
            do {
                digit = random.nextInt(10);
            } while (used[digit]);
            used[digit] = true;
            builder.append(digit);
        }
        secretNumber = builder.toString();
    }
}

