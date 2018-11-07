import GameEngine.Game;
import GameModes.GameMode;
import World.Utils;
import World.WorldConfiguration;

/**
 * Created by william on 2017-10-21.
 */
public class Main {

    public static void main(String[] args) {
        Game game = new Game("New Game Version 3", 800, 500);
        game.Start();

        //GameMode gameMode = new GameMode("rpg");
        //gameMode.RPGMode();
        //WorldConfiguration config = new WorldConfiguration(gameMode, "Test", "res/map.txt", 30, 30);
        //Utils.SaveWorldConfiguration(config, "res/WorldConfigTest.txt");

       // WorldConfiguration config = Utils.LoadWorldConfiguration("res/WorldConfigTest.txt");
        //String test = "";


    }

}
