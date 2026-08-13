import javax.swing.*;

import java.awt.*;

public class Scene extends JPanel {

    private final Snake snake;
    public Scene(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);

        this.snake = new Snake(100, 100);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.snake.draw(graphics);
    }
}