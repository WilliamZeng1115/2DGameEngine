package World;

import GameModes.GameMode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by william on 2017-10-22.
 */
public class WorldConfiguration {

    private int mapWidth, mapHeight;
    private String mapName;
    private String mapPath;
    private GameMode gameMode;

    public WorldConfiguration(GameMode gameMode, String mapName, String mapPath, int mapWidth, int mapHeight) {
        this.gameMode = gameMode;
        this.mapName = mapName;
        this.mapPath = mapPath;
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
    }

    public int[][] LoadMap() {
        int[][] parsedMap = new int[mapWidth][mapHeight];
        try {
            int rowCounter = 0;

            BufferedReader br = new BufferedReader(new FileReader(mapPath));
            String line;
            while ((line = br.readLine()) != null && rowCounter < mapHeight) {
                String[] columnElements = line.split("\\s+");
                for(int i =0; i < mapWidth; i++) {
                    parsedMap[i][rowCounter] = Integer.parseInt(columnElements[i]);
                }
                rowCounter++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parsedMap;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public String getMapName() {
        return mapName;
    }

    public GameMode getGameMode() {
        return gameMode;
    }
}
