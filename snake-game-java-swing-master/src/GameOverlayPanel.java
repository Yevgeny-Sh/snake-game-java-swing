import javax.swing.*;
import java.awt.*;

public class GameOverlayPanel extends JPanel {

    private final JLabel titleLabel;
    private final JLabel movementLabel;
    private final JLabel pauseLabel;
    private final JLabel goalLabel;
    private final JButton startButton;

    public GameOverlayPanel(int x, int y, int width, int height) {

        this.setBounds(x, y, width, height);
        this.setBackground(new Color(245, 245, 245));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(Box.createVerticalStrut(150));

        this.titleLabel = new JLabel("SNAKE");
        this.titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        this.titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(titleLabel);
        this.add(Box.createVerticalStrut(50));

        this.movementLabel = new JLabel("Move: W A S D");
        this.movementLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        this.movementLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.pauseLabel = new JLabel("Pause / Resume: Space");
        this.pauseLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        this.pauseLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.goalLabel = new JLabel("Eat apples and avoid walls and yourself");
        this.goalLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        this.goalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(movementLabel);
        this.add(Box.createVerticalStrut(15));
        this.add(pauseLabel);
        this.add(Box.createVerticalStrut(15));
        this.add(goalLabel);

        this.add(Box.createVerticalStrut(50));

        this.startButton = new JButton("Start Game");
        this.startButton.setFont(new Font("Arial", Font.BOLD, 20));
        this.startButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(startButton);
    }

    public JButton getStartButton() {
        return startButton;
    }

    public void showGameOver(int score) {

        titleLabel.setText("GAME OVER");

        movementLabel.setVisible(false);
        pauseLabel.setVisible(false);

        goalLabel.setText("Score: " + score);

        startButton.setText("New Game");
        startButton.setEnabled(true);
        setVisible(true);
    }
}