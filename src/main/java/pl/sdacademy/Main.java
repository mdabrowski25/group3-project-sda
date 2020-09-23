package pl.sdacademy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        ApiDataProvider apiDataProvider = new ApiDataProvider();
        CoronaPeople coronaPeople = apiDataProvider.get("src/main/resources/simpleJsonExample.json");
        System.out.println(coronaPeople.toString());


    }
}
