package GameEngine;
import Graphics.Assets;
import Inputs.KeyManager;
import States.EntityState;
import States.GameState;
import States.MenuState;
import States.StateManager;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by william on 2017-10-21.
 */
public class Game implements Runnable{

    private Boolean running = false;
    private Thread thread;
    private Display display;

    private KeyManager keyManager;
    private ArrayList<MouseAdapter> adaptors;
    private Map<String, EntityState> states;

    private static int gameHeight, gameWidth;
    private String gameTitle;

    private static final int FPS = 30;
    private static final double TIME_PER_TICK = 1000000000 / FPS;

    public Game(String title, int width, int height) {
        gameTitle = title;
        gameHeight = height;
        gameWidth = width;
        keyManager = new KeyManager();
        adaptors = new ArrayList<MouseAdapter>();
        states = new HashMap<String, EntityState>();
    }

    public synchronized void Start() {
        if(running) return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    // if game is afk for longer than eg 5 min then call stop
    public synchronized  void Stop() {
        if(!running) return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Assets.InitializeAssets();
        InitializeDisplay();
        InitializeGameStates();

        GameLoop();

        Stop();
    }

    private void InitializeDisplay() {
        display = new Display(gameTitle, gameWidth, gameHeight);
    }

    private void InitializeGameStates() {
        MenuState menuState = new MenuState(states, adaptors, display);
        GameState gameState = new GameState(states, adaptors, display);
        display.AddListeners(keyManager, adaptors);

        gameState.SetWorld("res/worldConfigTest.txt");

        StateManager.setCurrentState(gameState);
    }

    private void GameLoop() {
        double changeInTime = 0;
        long currentTime;

        long lastTime =  System.nanoTime();

        while(running) {
            currentTime = System.nanoTime();
            changeInTime += (currentTime - lastTime) / TIME_PER_TICK;
            lastTime = currentTime;

            if(changeInTime >= 1) {
                tick();
                render();
                changeInTime = 0;
            }
        }
    }

    private void tick() {
        if(StateManager.getCurrentState() != null)
            StateManager.getCurrentState().tick();
    }

    private void render() {
        BufferStrategy bufferStrategy = display.getBufferStrategy();
        if(bufferStrategy == null) {
            display.createBufferStrategy(3);
            return;
        }
        Graphics graphics = bufferStrategy.getDrawGraphics();
        graphics.clearRect(0, 0, gameWidth, gameHeight);
        if(StateManager.getCurrentState() != null)
            StateManager.getCurrentState().render(graphics);
        bufferStrategy.show();
        graphics.dispose();
    }

    private EntityState getState(String stateName) {
        return states.get(stateName);
    }

    public static int getWidth() {
        return gameWidth;
    }

    public static int getHeight() {
        return gameHeight;
    }
}
