import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    private final JLabel scoreLabel;

    public MenuPanel(int x, int y, int width, int height) {

        this.setBounds(x, y, width, height);
        this.setBackground(new Color(245, 245, 245));

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(Box.createVerticalStrut(50));

        this.scoreLabel = new JLabel("Score: 0");
        this.scoreLabel.setFont(new Font("Arial", Font.BOLD, 26));
        this.scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(scoreLabel);
    }

    public void updateScore(int score) {
        scoreLabel.setText("Score: " + score);
    }
}