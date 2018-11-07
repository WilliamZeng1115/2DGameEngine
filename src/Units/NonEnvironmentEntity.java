package Units;

/**
 * Created by william on 2017-10-22.
 */
public abstract class NonEnvironmentEntity extends Entity {

    protected double xSpeed, ySpeed;

    protected double health;
    protected int gold;
    protected String name, description;

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setXSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setYSpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }
}
