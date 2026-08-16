import javax.swing.*;
import java.awt.*;

public class Main {

    public static final int WINDOW_WIDTH = 1200;
    public static final int WINDOW_HEIGHT = 800;

    public static void main(String[] args) {

        JFrame window = new JFrame("snake");

        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLayout(null);

        window.getContentPane().setPreferredSize(
                new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT)
        );

        window.pack();

        window.add(
                new Scene(
                        WINDOW_WIDTH / 5,
                        0,
                        WINDOW_WIDTH - WINDOW_WIDTH / 5,
                        WINDOW_HEIGHT
                )
        );

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}