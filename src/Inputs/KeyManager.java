package Inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by William on 2016-04-28.
 */
public class KeyManager implements KeyListener {

    private boolean[] keys;

    public KeyManager() {
        keys = new boolean[256];
    }

    public void tick() {

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
            keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
}
