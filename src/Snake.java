import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Snake {

    private static final int HEAD_SIZE = 80;

    private int x;
    private int y;
    private final Image snakeHeadImage;

    public Snake(int x, int y) {
        this.x = x;
        this.y = y;

        URL imageUrl = getClass().getResource("/images/snake-head.png");

        if (imageUrl != null) {
            this.snakeHeadImage = new ImageIcon(imageUrl).getImage();
        } else {
            this.snakeHeadImage = null;
        }
    }

    public void moveRight() {
        this.x += 10;
    }

    public void moveLeft() {
        this.x -= 10;
    }

    public void moveUp() {
        this.y -= 10;
    }

    public void moveDown() {
        this.y += 10;
    }

    public void draw(Graphics graphics, Integer direction) {

        Graphics2D graphics2D = (Graphics2D) graphics.create();

        int centerX = this.x + HEAD_SIZE / 2;
        int centerY = this.y + HEAD_SIZE / 2;

        double angle = 0;

        if (direction != null) {

            if (direction == 0) {
                angle = Math.toRadians(270); // RIGHT
            }

            if (direction == 1) {
                angle = Math.toRadians(90); // LEFT
            }

            if (direction == 2) {
                angle = Math.toRadians(0); // DOWN
            }

            if (direction == 3) {
                angle = Math.toRadians(180); // UP
            }
        }

        graphics2D.rotate(
                angle,
                centerX,
                centerY
        );

        if (this.snakeHeadImage != null) {

            graphics2D.drawImage(
                    this.snakeHeadImage,
                    this.x,
                    this.y,
                    HEAD_SIZE,
                    HEAD_SIZE,
                    null
            );

        } else {

            graphics2D.setColor(Color.BLACK);
            graphics2D.fillRect(
                    this.x,
                    this.y,
                    HEAD_SIZE,
                    HEAD_SIZE
            );
        }

        graphics2D.dispose();
    }
}