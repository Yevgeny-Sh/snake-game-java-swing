import javax.swing.*;
import java.awt.*;

public class Scene extends JPanel {

    private final Snake snake;
    private Integer direction = null;
    private Food food;
    private static final int BORDER_SIZE = 10;
    public Scene(int x, int y, int width, int height) {

        this.setBounds(x, y, width, height);

        this.snake = new Snake(330, 330);
        this.food = new Food(330, 250);

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

        graphics.setColor(Color.black);

        graphics.fillRect(0, 0, getWidth(), BORDER_SIZE);
        graphics.fillRect(0, getHeight() - BORDER_SIZE, getWidth(), BORDER_SIZE);

        graphics.fillRect(0, 0, BORDER_SIZE, getHeight());
        graphics.fillRect(getWidth() - BORDER_SIZE, 0, BORDER_SIZE, getHeight());

        this.snake.draw(graphics, this.direction);
        this.food.draw(graphics);
    }

    private boolean hasWallCollision() {

        return snake.getX() < BORDER_SIZE ||
                snake.getY() < BORDER_SIZE ||
                snake.getX() + Snake.TILE_SIZE > getWidth() - BORDER_SIZE ||
                snake.getY() + Snake.TILE_SIZE > getHeight() - BORDER_SIZE;
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

                    if (hasWallCollision()) {
                        break;
                    }

                    if (snake.getX() == food.getX() &&
                            snake.getY() == food.getY()) {

                        snake.grow();
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