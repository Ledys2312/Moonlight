package Objects;

import java.awt.*;

public class Star {

    public int x, y;
    public int speed;
    public Image image;

    public Star(int x, int y, int speed, Image image) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.image = image;
    }

    public void update() {
        y += speed;
    }


}
