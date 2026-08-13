import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Snake {

    private static final int HEAD_SIZE = 80;

    private final int x;
    private final int y;
    private Image snakeHeadImage;

    public Snake(int x, int y) {
        this.x = x;
        this.y = y;

        URL imageUrl = getClass().getResource("/images/snake-head.png");

        if (imageUrl != null) {
            this.snakeHeadImage = new ImageIcon(imageUrl).getImage();
        }
    }

    public void draw(Graphics graphics) {

        if (this.snakeHeadImage != null) {

            graphics.drawImage(
                    this.snakeHeadImage,
                    this.x,
                    this.y,
                    HEAD_SIZE,
                    HEAD_SIZE,
                    null
            );

        } else {

            graphics.setColor(Color.BLACK);

            graphics.fillRect(
                    this.x,
                    this.y,
                    HEAD_SIZE,
                    HEAD_SIZE
            );
        }
    }
}