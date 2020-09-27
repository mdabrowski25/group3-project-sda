package pl.sdacademy;

public class Main {
    public static void main(String[] args) {
        ApiDataProvider apiDataProvider = new ApiDataProvider();
        WorldCoronaPeople worldCoronaPeople = apiDataProvider.get();
        System.out.println(worldCoronaPeople.toString());
        System.out.println(worldCoronaPeople.getResult().getTotal_active_cases());
    }
}
