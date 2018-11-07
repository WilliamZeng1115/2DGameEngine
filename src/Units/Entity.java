package Units;

import States.GameState;

import java.awt.*;
import Graphics.GameCamera;
import java.awt.image.BufferedImage;

/**
 * Created by william on 2017-10-22.
 */
public abstract class Entity {

    protected double x, y;
    protected BufferedImage texture;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public abstract void tick();

    public void render(Graphics g) {
        g.drawImage(texture, (int)(x - GameCamera.getXTopLeft()), (int)(y - GameCamera.getYTopLeft()), null);
    };
}
