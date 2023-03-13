import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BullsAndCowsGameUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private static final int SECRET_NUMBER_LENGTH = 4;
    private static final int MAX_ATTEMPTS = 10;

    private int attemptsLeft;
    private String secretNumber;
    private JTextField guessTextField;
    private JLabel resultLabel;
    private JButton guessButton;

    public BullsAndCowsGameUI() {
        super("Bulls and Cows Game");

        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridLayout(2, 2));
        topPanel.add(new JLabel("Secret Number:"));
        topPanel.add(new JLabel(""));
        topPanel.add(new JLabel("Attempts Left:"));
        topPanel.add(new JLabel(""));
        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(2, 1));
        centerPanel.add(new JTextField(SECRET_NUMBER_LENGTH));
        guessTextField = new JTextField(SECRET_NUMBER_LENGTH);
        guessTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guessButton.doClick();
            }
        });
        centerPanel.add(guessTextField);
        add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        guessButton = new JButton("Guess");
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (attemptsLeft == 0) {
                    JOptionPane.showMessageDialog(BullsAndCowsGameUI.this, "You have no attempts left.");
                    return;
                }
                String guess = guessTextField.getText();
                if (guess.length() != SECRET_NUMBER_LENGTH) {
                    JOptionPane.showMessageDialog(BullsAndCowsGameUI.this, "Guess should be " + SECRET_NUMBER_LENGTH + " digits long.");
                    return;
                }
                int bulls = 0;
                int cows = 0;
                for (int i = 0; i < SECRET_NUMBER_LENGTH; i++) {
                    char c = guess.charAt(i);
                    if (secretNumber.charAt(i) == c) {
                        bulls++;
                    } else if (secretNumber.indexOf(c) != -1) {
                        cows++;
                    }
                }
                if (bulls == SECRET_NUMBER_LENGTH) {
                    JOptionPane.showMessageDialog(BullsAndCowsGameUI.this, "Congratulations! You guessed the secret number in " + (MAX_ATTEMPTS - attemptsLeft + 1) + " attempts.");
                    resetGame();
                } else {
                    attemptsLeft--;
                    resultLabel.setText("Bulls: " + bulls + " Cows: " + cows);
                    topPanel.getComponent(1).setText(secretNumber);
                    topPanel.getComponent(3).setText("" + attemptsLeft);
                    guessTextField.setText("");
                }
                if (attemptsLeft == 0) {
                    JOptionPane.showMessageDialog(BullsAndCowsGameUI.this, "You have no attempts left.");
                    resetGame();
                }
            }
        });
        bottomPanel.add(guessButton, BorderLayout.WEST);
        resultLabel = new JLabel("");
        bottomPanel.add(resultLabel, BorderLayout.CENTER);
        add(bottom Panel, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);

        resetGame();
    }

    private void resetGame() {
        attemptsLeft = MAX_ATTEMPTS;
        secretNumber = generateSecretNumber();
        resultLabel.setText("");
        guessTextField.setText("");
        topPanel.getComponent(1).setText("");
        topPanel.getComponent(3).setText("" + attemptsLeft);
    }

    private String generateSecretNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < SECRET_NUMBER_LENGTH) {
            int digit = random.nextInt(10);
            if (sb.indexOf("" + digit) == -1) {
                sb.append(digit);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new BullsAndCowsGameUI();
    }


