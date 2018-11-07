package World;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;

/**
 * Created by william on 2017-10-22.
 */
public class Utils {

    // can create a table in database rather than to json...
    public static void SaveWorldConfiguration(WorldConfiguration worldConfig, String path) {
        Gson gson = new Gson();
        String jsonWorldConfig = gson.toJson(worldConfig);
        StoreJsonToFile(path, jsonWorldConfig);
    }

    private static void StoreJsonToFile(String fileName, String json) {
        PrintWriter pw = null;
        try {
            File file = new File(fileName);
            file.createNewFile();
            FileWriter fw = new FileWriter(file, true);
            pw = new PrintWriter(fw);
            pw.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    public static WorldConfiguration LoadWorldConfiguration(String path) {
        Gson gson = new Gson();
        WorldConfiguration worldConfiguration = null;
        try {
            JsonReader reader = new JsonReader(new FileReader(path));
            worldConfiguration = gson.fromJson(reader, WorldConfiguration.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return worldConfiguration;
    }
}
