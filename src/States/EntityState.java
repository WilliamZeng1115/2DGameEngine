package States;

import GameEngine.Display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by william on 2017-10-21.
 */
public abstract class EntityState extends MouseAdapter {

    protected ArrayList<JButton> buttons;
    protected int mouseX, mouseY;
    protected Boolean mouseReleased;
    protected Display display;

    public EntityState(String stateName, Map<String, EntityState> states, ArrayList<MouseAdapter> adaptors, Display display) {
        states.put(stateName, this);
        adaptors.add(this);
        this.display = display;
        buttons = new ArrayList<JButton>();
        mouseReleased = true;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(StateManager.getCurrentState() != this) return;
        setMousePos(e);
        mouseReleased = false;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(StateManager.getCurrentState() != this) return;
        mouseReleased = true;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(StateManager.getCurrentState() != this) return;
        setMousePos(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (StateManager.getCurrentState() != this) return;
        setMousePos(e);
    }

    protected boolean mouseOver(int x, int y, int width, int height) {
        if (mouseX > x && mouseX < x + width) {
            if (mouseY > y && mouseY < y + height)
                return true;

        }
        return false;
    }

    private void setMousePos(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    public Boolean getMouseReleased() {
        return mouseReleased;
    }

    public abstract void tick();

    public abstract void render(Graphics g);
}
