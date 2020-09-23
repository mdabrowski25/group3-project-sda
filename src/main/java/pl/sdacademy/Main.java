package pl.sdacademy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        File file = new File("src/main/resources/simpleJsonExample.json");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        WorldCoronaPeople worldCoronaPeople = gson.fromJson(bufferedReader, WorldCoronaPeople.class);
        System.out.println(worldCoronaPeople.getInfected());
        System.out.println(worldCoronaPeople.getDeceased());

    }
}
