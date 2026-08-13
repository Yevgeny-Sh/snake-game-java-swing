import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Snake {

    private static final int HEAD_SIZE = 80;

    private int x;
    private int y;

    private final int[] bodyX;
    private final int[] bodyY;

    private final Image snakeHeadImage;

    public Snake(int x, int y) {
        this.x = x;
        this.y = y;

        // כרגע לנחש יש 3 חלקי גוף
        this.bodyX = new int[3];
        this.bodyY = new int[3];

        // הגוף מתחיל משמאל לראש
        this.bodyX[0] = x - 80;
        this.bodyY[0] = y;

        this.bodyX[1] = x - 160;
        this.bodyY[1] = y;

        this.bodyX[2] = x - 240;
        this.bodyY[2] = y;

        URL imageUrl = getClass().getResource("/images/snake-head.png");

        if (imageUrl != null) {
            this.snakeHeadImage = new ImageIcon(imageUrl).getImage();
        } else {
            this.snakeHeadImage = null;
        }
    }

    private void moveBody() {

        // מתחילים מהחלק האחרון
        for (int i = bodyX.length - 1; i > 0; i--) {

            bodyX[i] = bodyX[i - 1];
            bodyY[i] = bodyY[i - 1];
        }

        // החלק הראשון מקבל את המקום הנוכחי של הראש
        bodyX[0] = x;
        bodyY[0] = y;
    }

    public void moveRight() {

        moveBody();
        this.x += 80;
    }

    public void moveLeft() {

        moveBody();
        this.x -= 80;
    }

    public void moveUp() {

        moveBody();
        this.y -= 80;
    }

    public void moveDown() {

        moveBody();
        this.y += 80;
    }

    public void draw(Graphics graphics, Integer direction) {

        // מציירים קודם את הגוף
        graphics.setColor(Color.GREEN);

        for (int i = 0; i < bodyX.length; i++) {

            graphics.fillRect(
                    bodyX[i],
                    bodyY[i],
                    80,
                    80
            );
        }


        // ואז מציירים את הראש
        Graphics2D graphics2D = (Graphics2D) graphics.create();

        int centerX = this.x + HEAD_SIZE / 2;
        int centerY = this.y + HEAD_SIZE / 2;

        double angle = 0;

        if (direction != null) {

            if (direction == 0) {
                angle = Math.toRadians(270);

            } else if (direction == 1) {
                angle = Math.toRadians(90);

            } else if (direction == 2) {
                angle = Math.toRadians(0);

            } else if (direction == 3) {
                angle = Math.toRadians(180);
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