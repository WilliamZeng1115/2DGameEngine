package World;

import GameEngine.Game;
import Graphics.GameCamera;
import Graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by william on 2017-10-22.
 */
public class World {

    // Temporary -> can just create a table in database and directly get these fields and a model..
    public enum Tile {
        Ground(0, false, Assets.ground), Wall(1, true, Assets.wall);

        private int id;
        private Boolean solid;
        private BufferedImage texture;
        public static final int TILEWIDTH = 65, TILEHEIGHT = 65;

        Tile(int id, Boolean solid, BufferedImage texture) {
            this.id = id;
            this.solid = solid;
            this.texture = texture;
        }

        public Boolean isSolid() {
            return solid;
        }

        public static Tile getById(int id) {
            for(Tile tile : values()) {
                if(id == tile.id) return tile;
            }
            return Tile.Ground;
        }

        public void render(Graphics g, int x, int y) {
            g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
        }
    }

    private Tile[][] map;
    private WorldConfiguration worldConfig;

    private int mapHeight, mapWidth;

    public World(String configPath) {
        LoadWorldConfigAndMap(configPath);
    }

    private void LoadWorldConfigAndMap(String configPath) {
        worldConfig = Utils.LoadWorldConfiguration(configPath);

        int[][] mapLoadedFromConfig = worldConfig.LoadMap();
        mapWidth = worldConfig.getMapWidth();
        mapHeight = worldConfig.getMapHeight();
        map = new Tile[mapWidth][mapHeight];
        for(int i = 0; i < mapHeight; i++) {
            for(int j = 0; j < mapWidth; j++) {
                map[j][i] = Tile.getById(mapLoadedFromConfig[j][i]);
            }
        }
    }

    public void tick() {

    }

    public void render(Graphics g) {
        int xStart = (int)Math.max(0, GameCamera.getXTopLeft() / Tile.TILEWIDTH);
        int xEnd = (int)Math.min(mapWidth, (GameCamera.getXTopLeft() + Game.getWidth()) / Tile.TILEWIDTH + 1);
        int yStart = (int)Math.max(0, GameCamera.getYTopLeft() / Tile.TILEHEIGHT);;
        int yEnd = (int)Math.min(mapHeight, (GameCamera.getYTopLeft() + Game.getHeight()) / Tile.TILEHEIGHT + 1);;

        for(int y = yStart; y < yEnd; y++)  {
            for(int x = xStart; x < xEnd; x++) {
                map[x][y].render(g, (int)(x * Tile.TILEWIDTH - GameCamera.getXTopLeft()), (int)(y * Tile.TILEHEIGHT - GameCamera.getYTopLeft()));
            }
        }
    }

    public WorldConfiguration getWorldConfig() {
        return worldConfig;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public int getMapWidth() {
        return mapWidth;
    }
}
