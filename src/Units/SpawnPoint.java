package Units;

import Graphics.Assets;
import sun.awt.image.ImageWatched;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by william on 2017-10-26.
 */
public class SpawnPoint {

    private LinkedList<Unit> units;
    private double x, y, radius;

    public SpawnPoint(double x, double y, double radius, int numToSpawn) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        units = new LinkedList<Unit>();
        CreateUnits(numToSpawn);
    }

    private void CreateUnits(int numToSpawn) {
        for(int i = 0; i < numToSpawn; i++) {
            double randomRadius = Math.random() * radius;
            double randomAngle = Math.random() * 360;
            double randomX = Math.cos(randomAngle) * randomRadius + x;
            double randomY = Math.sin(randomAngle) * randomRadius + y;
            Unit u = new Unit(randomX, randomY, Assets.unit, 100, 100, "Test Unit", "This is a test description");
            u.setXSpeed(Math.random() * 5);
            u.setYSpeed(Math.random() * 5);
            units.add(u);
        }
    }

    public LinkedList<Unit> getUnits() {
        return units;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public void tick() {
        units.forEach(Unit::tick);
    }

    public void render(Graphics g) {
        for(Unit u : units) u.render(g);
    }
}
