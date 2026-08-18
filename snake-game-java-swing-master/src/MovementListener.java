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

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            scene.togglePause();
            return;
        }

        // ימינה - D או חץ ימינה
        if (e.getKeyCode() == KeyEvent.VK_D ||
            e.getKeyCode() == KeyEvent.VK_RIGHT) {

            scene.setDirection(0);

        // שמאלה - A או חץ שמאלה
        } else if (e.getKeyCode() == KeyEvent.VK_A ||
                   e.getKeyCode() == KeyEvent.VK_LEFT) {

            scene.setDirection(1);

        // למטה - S או חץ למטה
        } else if (e.getKeyCode() == KeyEvent.VK_S ||
                   e.getKeyCode() == KeyEvent.VK_DOWN) {

            scene.setDirection(2);

        // למעלה - W או חץ למעלה
        } else if (e.getKeyCode() == KeyEvent.VK_W ||
                   e.getKeyCode() == KeyEvent.VK_UP) {

            scene.setDirection(3);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}