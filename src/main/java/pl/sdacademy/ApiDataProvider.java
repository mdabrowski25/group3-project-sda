package pl.sdacademy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class ApiDataProvider {
    private final GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
    private final Gson gson = builder.create();

    public CoronaPeople get(String jsonPath) {
        File file = new File(jsonPath);
        CoronaPeople coronaPeople = null;

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            coronaPeople = gson.fromJson(bufferedReader, CoronaPeople.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (coronaPeople != null)
            return coronaPeople;
        else
            throw new NullPointerException("Błąd odczytania obiektu z pliku");
    }
    public CoronaPeople get(){
        return get("data.json");
    }
}
