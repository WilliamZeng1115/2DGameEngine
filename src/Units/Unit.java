package Units;

import GameEngine.Game;
import States.GameState;
import World.WorldConfiguration;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by william on 2017-10-26.
 */
public class Unit extends NonEnvironmentEntity {

    public Unit(double x, double y, BufferedImage texture, int health, int gold, String name, String description) {
        this.x = x;
        this.y = y;
        this.texture = texture;
        this.health = health;
        this.gold = gold;
        this.name = name;
        this.description = description;
    }

    private void move() {
        x += xSpeed;
        y += ySpeed;
        tempMoveConfig();
    }

    private void tempMoveConfig() {
        if(x < 0)
            xSpeed = 5 * Math.random();
        else if(x > 30 * 65)
            xSpeed = -5 * Math.random();
        if(y < 0)
            ySpeed = 5 * Math.random();
        else if(y > 30 * 65)
           ySpeed = -5 * Math.random();
    }

    @Override
    public void tick() {
        move();
    }
}
