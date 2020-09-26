package pl.sdacademy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;
import java.io.FileWriter;
import java.io.*;
import java.net.URL;

public class ApiDataProvider {
    private final GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
    private final Gson gson = builder.create();

    private WorldCoronaPeople get(String jsonPath) {
        WorldCoronaPeople worldCoronaPeople = null;

        try (FileReader fileReader = new FileReader(jsonPath);
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

    public WorldCoronaPeople get() {
        try {
            saveUrlToJsonFile();
        } catch (IOException e) {
            System.err.println("Błąd zapisu url do pliku");
            e.printStackTrace();
        }
        return get("src/main/resources/data.json");
    }

    private void saveUrlToJsonFile() throws IOException {
        String json = readUrl("https://api.thevirustracker.com/free-api?global=stats");
        File file = new File("src/main/resources/data.json");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(json);
        bufferedWriter.flush();
        fileWriter.close();
        bufferedWriter.close();
    }

    private static String readUrl(String urlString) throws IOException {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }
}
