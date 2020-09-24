package pl.sdacademy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class ApiDataProvider {
    private final GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
    private final Gson gson = builder.create();

    public WorldCoronaPeople get(String jsonPath) {
        File file = new File(jsonPath);
        WorldCoronaPeople worldCoronaPeople = null;

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            worldCoronaPeople = gson.fromJson(bufferedReader, WorldCoronaPeople.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (worldCoronaPeople != null)
            return worldCoronaPeople;
        else
            throw new NullPointerException("Błąd odczytania obiektu z pliku");
    }
    public WorldCoronaPeople get(){
        return get("data.json");
    }
}
