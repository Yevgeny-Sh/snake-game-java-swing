import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;

public class Snake {

    public static final int TILE_SIZE = 80;
    private int x;
    private int y;

    private final ArrayList<Point> bodyParts;
    private int desiredBodyLength;

    private final Image snakeHeadImage;

    public Snake(int x, int y) {
        this.x = x;
        this.y = y;

        this.bodyParts = new ArrayList<>();
        this.desiredBodyLength = 0;

        URL imageUrl = getClass().getResource("/images/snake-head.png");

        if (imageUrl != null) {
            this.snakeHeadImage = new ImageIcon(imageUrl).getImage();
        } else {
            this.snakeHeadImage = null;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private void moveBody() {
        bodyParts.add(0, new Point(x, y));

        if (bodyParts.size() > desiredBodyLength) {
            bodyParts.remove(bodyParts.size() - 1);
        }
    }

    public void grow() {
        desiredBodyLength++;
    }
    public boolean hasBody() {
        return desiredBodyLength > 0;
    }

    public void moveRight() {
        moveBody();
        this.x += TILE_SIZE;
    }

    public void moveLeft() {
        moveBody();
        this.x -= TILE_SIZE;
    }

    public void moveUp() {
        moveBody();
        this.y -= TILE_SIZE;
    }

    public void moveDown() {
        moveBody();
        this.y += TILE_SIZE;
    }
    public boolean hasSelfCollision() {

        for (Point bodyPart : bodyParts) {

            if (x == bodyPart.x && y == bodyPart.y) {
                return true;
            }
        }
        return false;
    }
    public boolean occupiesPosition(int x, int y) {

        if (this.x == x && this.y == y) {
            return true;
        }

        for (Point bodyPart : bodyParts) {
            if (bodyPart.x == x && bodyPart.y == y) {
                return true;
            }
        }

        return false;
    }

    public void reset(int x, int y) {
        this.x = x;
        this.y = y;

        bodyParts.clear();
        desiredBodyLength = 0;
    }
    public void draw(Graphics graphics, Integer direction) {
        graphics.setColor(Color.DARK_GRAY);
        for (Point bodyPart : bodyParts) {
            graphics.fillRect(
                    bodyPart.x,
                    bodyPart.y,
                    TILE_SIZE,
                    TILE_SIZE
            );
        }

        Graphics2D graphics2D = (Graphics2D) graphics.create();

        int centerX = this.x + TILE_SIZE / 2;
        int centerY = this.y + TILE_SIZE / 2;

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

        graphics2D.rotate(angle, centerX, centerY);

        if (this.snakeHeadImage != null) {
            graphics2D.drawImage(
                    this.snakeHeadImage,
                    this.x,
                    this.y,
                    TILE_SIZE,
                    TILE_SIZE,
                    null
            );
        } else {
            graphics2D.setColor(Color.BLACK);

            graphics2D.fillRect(
                    this.x,
                    this.y,
                    TILE_SIZE,
                    TILE_SIZE
            );
        }

        graphics2D.dispose();
    }
}