package pl.sdacademy;

public class Main {
    public static void main(String[] args) {
        ApiDataProvider apiDataProvider = new ApiDataProvider();
        CoronaPeople coronaPeople = apiDataProvider.get("src/main/resources/simpleJsonExample.json");
        System.out.println(coronaPeople.toString());


    }
}
