package pl.sdacademy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

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
        URL url = new URL("https://api.thevirustracker.com/free-api?global=stats");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        InputStream in = new BufferedInputStream(urlConnection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
        String jsonString = readAll(bufferedReader);

        File file = new File("src/main/resources/data.json");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        gson.toJson(jsonString, bufferedWriter);

        closeAllConnections(urlConnection, fileWriter, bufferedWriter, in, bufferedReader);
    }

    private void closeAllConnections(HttpURLConnection urlConnection, FileWriter fileWriter,
                                     BufferedWriter bufferedWriter, InputStream in, BufferedReader bufferedReader) throws IOException {
        urlConnection.disconnect();
        fileWriter.close();
        bufferedWriter.close();
        in.close();
        bufferedReader.close();
    }

    private String readAll(BufferedReader reader) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        while (reader.readLine() != null) {
            stringBuilder.append(reader.readLine());
        }
        return stringBuilder.toString();

    }
}
