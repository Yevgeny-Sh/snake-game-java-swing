import javax.swing.*;
public class Main {
    public static final int WINDOW_WIDTH = 1200;
    public static final int WINDOW_HEIGHT = 800;


    public static void main(String[] args) {

        JFrame window = new JFrame("snake");
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setResizable(false);
        window.add(new Scene(WINDOW_WIDTH / 5, 0, WINDOW_WIDTH - WINDOW_WIDTH / 5, WINDOW_HEIGHT));
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }
}