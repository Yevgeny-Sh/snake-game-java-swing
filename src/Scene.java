import javax.swing.*;
import java.awt.*;

public class Scene extends JPanel {

    private final Snake snake;
    private Integer direction = null;

    public Scene(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);

        this.snake = new Snake(100, 100);

        this.addKeyListener(new MovementListener(this.snake, this));

        this.setFocusable(true);
        this.requestFocus();
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.snake.draw(graphics, this.direction);
    }
}