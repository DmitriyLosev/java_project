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
            System.out.println("Введите " + SECRET_NUMBER_LENGTH + "-значное число (у вас есть " + attemptsLeft + " попыток):");
            String guess = scanner.next();
            if (guess.length() != SECRET_NUMBER_LENGTH) {
                System.out.println("Пожалуйста введитн " + SECRET_NUMBER_LENGTH + "-значное число.");
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
                System.out.println("Вы победили!");
                break;
            } else if (attemptsLeft == 0) {
                System.out.println("Вы проиграли. Загаданное число " + secretNumber + ".");
                break;
            } else {
                System.out.println(bulls + " Быки и " + cows + " Коровы. Попробуйте снова.");
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
