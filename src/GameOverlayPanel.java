import javax.swing.*;
import java.awt.*;

public class GameOverlayPanel extends JPanel {

    private final JButton startButton;

    public GameOverlayPanel(int x, int y, int width, int height) {

        this.setBounds(x, y, width, height);
        this.setBackground(new Color(245, 245, 245));

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(Box.createVerticalStrut(150));

        JLabel titleLabel = new JLabel("SNAKE");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(titleLabel);

        this.add(Box.createVerticalStrut(50));

        JLabel movementLabel = new JLabel("Move: W A S D");
        movementLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        movementLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel pauseLabel = new JLabel("Pause / Resume: Space");
        pauseLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        pauseLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel goalLabel = new JLabel("Eat apples and avoid walls and yourself");
        goalLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        goalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

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
}