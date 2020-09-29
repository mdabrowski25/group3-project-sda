package pl.sdacademy.apiCore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.*;
import java.net.URL;

public class ApiDataProvider<T extends CoronaPeople> {
    private final GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
    private final Gson gson = builder.create();

    public T get(String apiURL, Class<T> clazz) {
        try {
            saveUrlToJsonFile(apiURL);
        } catch (IOException e) {
            System.err.println("Błąd zapisu url do pliku");
            e.printStackTrace();
        }
        T coronaPeople = null;

        try (FileReader fileReader = new FileReader("src/main/resources/data.json");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            coronaPeople = gson.fromJson(bufferedReader, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (coronaPeople != null)
            return coronaPeople;
        else
            throw new NullPointerException("Błąd odczytania obiektu z pliku");
    }

    private void saveUrlToJsonFile(String apiURL) throws IOException {
        String json = readUrl(apiURL);
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
            StringBuilder buffer = new StringBuilder();
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
