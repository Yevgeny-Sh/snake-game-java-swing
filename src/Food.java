import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Food {

    private static final int SIZE = 80;
    private int x;
    private int y;

    private final Image foodImage;

    public Food(int x, int y) {
        this.x = x;
        this.y = y;

        URL imageUrl = getClass().getResource("/images/apple.png");

        if (imageUrl != null) {
            this.foodImage = new ImageIcon(imageUrl).getImage();
        } else {
            this.foodImage = null;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics graphics) {

        if (this.foodImage != null) {
            graphics.drawImage(
                    this.foodImage,
                    this.x,
                    this.y,
                    SIZE,
                    SIZE,
                    null
            );

        } else {
            graphics.setColor(Color.RED);
            graphics.fillRect(
                    this.x,
                    this.y,
                    SIZE,
                    SIZE
            );
        }
    }
}