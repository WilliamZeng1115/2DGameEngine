package Graphics;

import java.awt.image.BufferedImage;

/**
 * Created by William on 2016-04-27.
 */
public class Assets {

    public static final int WIDTH = 32, HEIGHT = 32;

    public static BufferedImage ground, wall, unit; // unit is temporary

    public static void InitializeAssets() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/Sprite.png"));

        ground = sheet.crop(64, 64, WIDTH, HEIGHT);
        wall = sheet.crop(64, 0, WIDTH, HEIGHT);
        unit = sheet.crop(32, 64, WIDTH, HEIGHT);
    }
}
