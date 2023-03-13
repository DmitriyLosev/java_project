import java.util.Scanner;

public class BullsAndCowsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в игру \"Быки и Коровы\"!");
        System.out.println("Введите загаданное число (четырехзначное):");
        String secretNumber = scanner.next();
        while (secretNumber.length() != 4) {
            System.out.println("Неправильный формат числа. Введите четырехзначное число:");
            secretNumber = scanner.next();
        }
        int attempts = 0;
        while (true) {
            System.out.println("Введите число:");
            String guess = scanner.next();
            while (guess.length() != 4) {
                System.out.println("Неправильный формат числа. Введите четырехзначное число:");
                guess = scanner.next();
            }
            int bulls = 0, cows = 0;
            for (int i = 0; i < 4; i++) {
                if (guess.charAt(i) == secretNumber.charAt(i)) {
                    bulls++;
                } else if (secretNumber.contains(guess.charAt(i) + "")) {
                    cows++;
                }
            }
            System.out.println("Быки: " + bulls);
            System.out.println("Коровы: " + cows);
            attempts++;
            if (bulls == 4) {
                System.out.println("Поздравляем, вы отгадали число!");
                System.out.println("Количество попыток: " + attempts);
                break;
            }
        }
        scanner.close();
    }
}
