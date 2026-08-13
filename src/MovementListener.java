import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovementListener implements KeyListener {

    private final Snake snake;
    private final Scene scene;

    public MovementListener(Snake snake, Scene scene) {
        this.snake = snake;
        this.scene = scene;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_D) {
            this.scene.setDirection(0);
            this.snake.moveRight();

        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            this.scene.setDirection(1);
            this.snake.moveLeft();

        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            this.scene.setDirection(2);
            this.snake.moveDown();

        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            this.scene.setDirection(3);
            this.snake.moveUp();
        }

        this.scene.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}