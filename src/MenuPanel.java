import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    private final JLabel scoreLabel;
    private final JButton pauseButton;

    public MenuPanel(int x, int y, int width, int height) {

        this.setBounds(x, y, width, height);
        this.setBackground(new Color(245, 245, 245));

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(Box.createVerticalStrut(50));

        this.scoreLabel = new JLabel("Score: 0");
        this.scoreLabel.setFont(new Font("Arial", Font.BOLD, 26));
        this.scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(scoreLabel);

        this.pauseButton = new JButton("Pause");
        this.pauseButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(Box.createVerticalStrut(30));
        this.add(pauseButton);
    }

    public void updateScore(int score) {
        scoreLabel.setText("Score: " + score);
    }

    public JButton getPauseButton() {
        return pauseButton;
    }

    public void updateTextPauseButton(boolean paused) {
        if (paused) {
            pauseButton.setText("Resume");
        } else {
            pauseButton.setText("Pause");
        }
    }
}