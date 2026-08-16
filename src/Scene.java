import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Scene extends JPanel {

    private final Snake snake;
    private final Random random = new Random();

    private Integer direction = null;
    private Food food;
    private static final int BORDER_SIZE = 10;
    private int score = 0;
    private final MenuPanel menuPanel;

    //volatile - to make sure Swing Thread sees Game Thread
    private volatile boolean paused = false;
    public Scene(int x, int y, int width, int height, MenuPanel menuPanel) {

        this.setBounds(x, y, width, height);

        this.menuPanel = menuPanel;

        this.snake = new Snake(330, 330);
        this.food = new Food(330, 250);

        this.addKeyListener(new MovementListener(this));

        this.setFocusable(true);

    }

    public void startGame() {
        mainGameLoop();
    }

    public void setDirection(Integer newDirection) {

        if (paused) {
            return;
        }

        if (!snake.hasBody()) {
            this.direction = newDirection;
            return;
        }

        if ((direction == 0 && newDirection == 1) ||
                (direction == 1 && newDirection == 0) ||
                (direction == 2 && newDirection == 3) ||
                (direction == 3 && newDirection == 2)) {
            return;
        }

        this.direction = newDirection;
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

    private boolean willHitWall() {

        int nextX = snake.getX();
        int nextY = snake.getY();

        if (direction == 0) {
            nextX += Snake.TILE_SIZE;
        } else if (direction == 1) {
            nextX -= Snake.TILE_SIZE;
        } else if (direction == 2) {
            nextY += Snake.TILE_SIZE;
        } else if (direction == 3) {
            nextY -= Snake.TILE_SIZE;
        }

        return nextX < BORDER_SIZE ||
                nextY < BORDER_SIZE ||
                nextX + Snake.TILE_SIZE > getWidth() - BORDER_SIZE ||
                nextY + Snake.TILE_SIZE > getHeight() - BORDER_SIZE;
    }

    private void moveFoodToRandomPosition() {

        int columns = (getWidth() - 2 * BORDER_SIZE) / Snake.TILE_SIZE;
        int rows = (getHeight() - 2 * BORDER_SIZE) / Snake.TILE_SIZE;

        int x;
        int y;

        do {
            int randomColumn = random.nextInt(columns);
            int randomRow = random.nextInt(rows);

            x = BORDER_SIZE + randomColumn * Snake.TILE_SIZE;
            y = BORDER_SIZE + randomRow * Snake.TILE_SIZE;

        } while (snake.occupiesPosition(x, y));

        food.setPosition(x, y);
    }

    public void togglePause() {
        paused = !paused;
        menuPanel.updateTextPauseButton(paused);
        requestFocusInWindow();
    }

    private void mainGameLoop() {

        Thread gameThread = new Thread(() -> {

            while (true) {

                if (this.direction != null && !paused) {

                    if (willHitWall()) {
                        this.repaint();
                        break;
                    }

                    if (this.direction == 0) {
                        this.snake.moveRight();

                    } else if (this.direction == 1) {
                        this.snake.moveLeft();

                    } else if (this.direction == 2) {
                        this.snake.moveDown();

                    } else if (this.direction == 3) {
                        this.snake.moveUp();
                    }

                    if (snake.hasSelfCollision()) {
                        this.repaint();
                        break;
                    }

                    //ate an apple
                    if (snake.getX() == food.getX() &&
                            snake.getY() == food.getY()) {

                        snake.grow();

                        score++;
                        menuPanel.updateScore(score);

                        moveFoodToRandomPosition();
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