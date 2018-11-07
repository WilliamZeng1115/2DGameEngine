package Graphics;

import World.*;
import GameEngine.Game;
import States.GameState;
import Units.Entity;

/**
 * Created by william on 2016-12-24.
 */
public class GameCamera {

    private static double xTopLeft, yTopLeft;
    private GameState gameState;
    private double xShiftSpeed, yShiftSpeed;
    private Boolean lockedScreen;
    private Entity entity;

    public GameCamera(GameState gameState, Entity entity) {
        this.gameState = gameState;
        this.entity = entity;
        if(entity == null) {
            lockedScreen = false;
            xTopLeft = 0;
            yTopLeft = 0;
        }
        else {
            lockedScreen = true;
            center();
        }
    }

    // Center to texture size
    public void center() {
        if(lockedScreen && entity != null) {
            xTopLeft = entity.getX() - Game.getWidth() / 2;
            yTopLeft = entity.getY() - Game.getHeight() / 2;
            checkBoundary();
        }
    }

    public void shiftScreen() {
        if(!lockedScreen) {
            xTopLeft += xShiftSpeed;
            yTopLeft += yShiftSpeed;
            checkBoundary();
        }
    }

    private void checkBoundary(){
        World world = gameState.getWorld();
        if(xTopLeft < 0)
            xTopLeft = 0;
        else if(xTopLeft > world.getMapWidth() * World.Tile.TILEWIDTH - Game.getWidth())
            xTopLeft = world.getMapWidth() * World.Tile.TILEWIDTH - Game.getWidth();
        if(yTopLeft < 0)
            yTopLeft = 0;
        else if(yTopLeft > world.getMapHeight() * World.Tile.TILEHEIGHT - Game.getHeight())
            yTopLeft = world.getMapHeight() * World.Tile.TILEHEIGHT - Game.getHeight();
    }

    public void setXShiftSpeed(double xShiftSpeed) {
        this.xShiftSpeed = xShiftSpeed;
    }

    public void setYShiftSpeed(double yShiftSpeed) {
        this.yShiftSpeed = yShiftSpeed;
    }

    public Boolean getLockedScreen() {
        return lockedScreen;
    }

    public void setLockScreen(Boolean lock) {
        lockedScreen = lock;
    }

    public static double getXTopLeft() {
        return xTopLeft;
    }

    public static double getYTopLeft() {
        return yTopLeft;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public void tick() {
        if(lockedScreen) {
            center();
        } else shiftScreen();
    }
}
