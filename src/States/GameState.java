package States;

import GameEngine.Display;
import GameEngine.Game;
import Graphics.GameCamera;
import Units.SpawnPoint;
import World.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by william on 2017-10-22.
 */
public class GameState extends EntityState {

    private World world; // map and game types
    private GameCamera gameCamera; // camera
    private ArrayList<SpawnPoint> spawnPoints; // units, should put it in worlds and then load it. (new tile property call spawn tile)

    // private Unit player; // implement later

    public GameState(Map<String, EntityState> states, ArrayList<MouseAdapter> adaptors, Display display) {
        super("game", states, adaptors, display);
        gameCamera = new GameCamera(this, null);

        spawnPoints = new ArrayList<SpawnPoint>();
        SpawnPoint sp = new SpawnPoint(Game.getWidth() / 2, Game.getHeight() / 2, 600, 2);
        spawnPoints.add(sp);

        gameCamera.setEntity(sp.getUnits().getFirst());
        gameCamera.setLockScreen(true);

        CreateGameStateDisplay();
    }

    private void CreateGameStateDisplay() {
        JButton button = new JButton("Test Button");
        buttons.add(button); // make it into another panel to add the buttons then pass panel to main panel to add
        display.UpdatePanel(buttons);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
        if(gameCamera.getLockedScreen()) return;
        gameCamera.setXShiftSpeed(0);
        gameCamera.setYShiftSpeed(0);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        super.mouseExited(e);
        if(gameCamera.getLockedScreen()) return;
        if(mouseX >= Game.getWidth()) {
            gameCamera.setXShiftSpeed(10);
        } else if(mouseX <= 0) {
            gameCamera.setXShiftSpeed(-10);
        }
        if(mouseY >= Game.getHeight()) {
            gameCamera.setYShiftSpeed(10);
        } else if(mouseY <= 0) {
            gameCamera.setYShiftSpeed(-10);
        }
    }

    // add a try catch error when world is null and not intialized !!!!!!!!!
    @Override
    public void tick() {
        world.tick();

        // later only tick the spawn points within player range / camera range
        for(SpawnPoint sp : spawnPoints) {
            sp.tick();
        }
        gameCamera.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);

        // later only render the spawn points within player range / camera range
        for(SpawnPoint sp : spawnPoints) {
            sp.render(g);
        }
    }

    // set the world when picking a map from menu -> can't begin world before that or throw error/redirect
    public void SetWorld(String worldConfigPath) {
        world = new World(worldConfigPath);
    }

    public World getWorld() {
        return world;
    }

    public GameCamera getGameCamera() {
        return gameCamera;
    }
}
