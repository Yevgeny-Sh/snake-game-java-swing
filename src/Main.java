import javax.swing.*;
import java.awt.*;

public class Main {

    public static final int SIDE_PANEL_WIDTH = 240;
    public static final int WINDOW_WIDTH = 1220;
    public static final int WINDOW_HEIGHT = 820;

    public static void main(String[] args) {

        JFrame window = new JFrame("snake");

        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLayout(null);

        window.getContentPane().setPreferredSize(
                new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT)
        );

        window.pack();

        JLayeredPane layeredPane = new JLayeredPane();

        layeredPane.setBounds(
                0,
                0,
                WINDOW_WIDTH,
                WINDOW_HEIGHT
        );

        MenuPanel menuPanel = new MenuPanel(
                0,
                0,
                SIDE_PANEL_WIDTH,
                WINDOW_HEIGHT
        );

        GameOverlayPanel overlayPanel = new GameOverlayPanel(
                0,
                0,
                WINDOW_WIDTH,
                WINDOW_HEIGHT
        );

        Scene scene = new Scene(
                SIDE_PANEL_WIDTH,
                0,
                WINDOW_WIDTH - SIDE_PANEL_WIDTH,
                WINDOW_HEIGHT,
                menuPanel,
                overlayPanel
        );



        layeredPane.add(menuPanel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(scene, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(overlayPanel, JLayeredPane.PALETTE_LAYER);

        window.add(layeredPane);

        menuPanel.getPauseButton().setFocusable(false);
        menuPanel.getPauseButton().addActionListener(
                e -> scene.togglePause()
        );

        overlayPanel.getStartButton().addActionListener(e -> {
            overlayPanel.setVisible(false);
            scene.startGame();
            scene.requestFocusInWindow();
        });

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}