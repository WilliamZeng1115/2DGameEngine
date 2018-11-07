package States;
import GameEngine.Display;
import GameEngine.Game;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by William on 2016-04-27.
 */
public class MenuState extends EntityState {

    public MenuState(Map<String, EntityState> states, ArrayList<MouseAdapter> adaptors, Display display) {
        super("menu", states, adaptors, display);
        CreateMenuStateDisplay();
    }

    private void CreateMenuStateDisplay() {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);

        if (mouseOver(Game.getWidth() / 2 - 100, Game.getHeight() / 2, 200, 64)) {
                //StateManager.setCurrentState(game.getGameState());
        }
        if (mouseOver(Game.getWidth() / 2 - 100, Game.getHeight() / 2 + 208, 200, 64)) {
            System.exit(0);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        renderMenu(g);
    }

    private void renderMenu(Graphics g) {
        Font f = new Font("arial", 1, 100);
        Font f1 = new Font("arial", 1, 50);

        g.setColor(Color.black);
        g.fillRect(0, 0, Game.getWidth(), Game.getHeight());

        g.setFont(f);
        g.setColor(Color.green);
        g.drawString("RPG" , Game.getWidth() / 2 - 100, Game.getHeight() / 2 - 100);

        g.setFont(f1);
        g.setColor(Color.white);
        g.drawRect(Game.getWidth() / 2 - 100, Game.getHeight() / 2, 200, 64);
        g.drawString("Play", Game.getWidth() / 2 - 80, Game.getHeight() / 2 + 48);


        g.setColor(Color.white);
        g.drawRect(Game.getWidth() / 2 - 100, Game.getHeight() / 2 + 104, 200, 64);
        g.drawString("Help", Game.getWidth() / 2 - 80, Game.getHeight() / 2 + 148);


        g.setColor(Color.white);
        g.drawRect(Game.getWidth() / 2 - 100, Game.getHeight() / 2 + 208, 200, 64);
        g.drawString("Quit", Game.getWidth() / 2 - 80, Game.getHeight() / 2 + 258);
    }
}
