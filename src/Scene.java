import javax.swing.*;
import java.awt.*;

public class Scene extends JPanel {

    private final Snake snake;
    private Integer direction = null;

    public Scene(int x, int y, int width, int height) {

        this.setBounds(x, y, width, height);

        this.snake = new Snake(300, 300);

        this.addKeyListener(new MovementListener(this));

        this.setFocusable(true);
        this.requestFocus();

        this.mainGameLoop();
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    @Override
    public void paintComponent(Graphics graphics) {

        super.paintComponent(graphics);

        this.snake.draw(graphics, this.direction);
    }

    private void mainGameLoop() {

        Thread gameThread = new Thread(() -> {

            while (true) {

                if (this.direction != null) {

                    if (this.direction == 0) {

                        this.snake.moveRight();

                    } else if (this.direction == 1) {

                        this.snake.moveLeft();

                    } else if (this.direction == 2) {

                        this.snake.moveDown();

                    } else if (this.direction == 3) {

                        this.snake.moveUp();
                    }
                }

                this.repaint();

                try {

                    Thread.sleep(300);

                } catch (InterruptedException e) {

                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });

        gameThread.start();
    }
}