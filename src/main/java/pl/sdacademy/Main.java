package pl.sdacademy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        File file = new File("src/main/resources/jsonExample.json");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        casualObject casualObject = gson.fromJson(bufferedReader, casualObject.class);
        System.out.println(casualObject.getInfected());
        System.out.println(casualObject.getSecondInt());

    }
}
