import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovementListener implements KeyListener {

    private final Scene scene;

    public MovementListener(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_D) {
            this.scene.setDirection(0);

        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            this.scene.setDirection(1);

        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            this.scene.setDirection(2);

        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            this.scene.setDirection(3);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}