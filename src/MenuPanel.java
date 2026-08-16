import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    private final JLabel scoreLabel;

    public MenuPanel(int x, int y, int width, int height) {

        this.setBounds(x, y, width, height);
        this.setBackground(new Color(225, 225, 225));

        this.scoreLabel = new JLabel("Score: 0");

        this.add(scoreLabel);
    }

    public void updateScore(int score) {
        scoreLabel.setText("Score: " + score);
    }
}