package pl.sdacademy;

public class Main {
    public static void main(String[] args) {

        ApiDataProvider<WorldCoronaPeople> apiDataProvider = new ApiDataProvider<>();
        WorldCoronaPeople worldCoronaPeople = apiDataProvider.get("https://api.thevirustracker.com/free-api?global=stats", WorldCoronaPeople.class);
        System.out.println(worldCoronaPeople.toString());
        System.out.println(worldCoronaPeople.getResult().getTotal_active_cases());


        ApiDataProvider<CountryCoronaPeople> apiDataProvider2 = new ApiDataProvider<>();
        CountryCoronaPeople countryCoronaPeople = apiDataProvider2.get("https://api.covid19api.com/summary", CountryCoronaPeople.class);
        System.out.println(countryCoronaPeople.getCountries().toString());

        
//        SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory("hibernate.cfg.xml");
//        Session session = sessionFactory.openSession();
//        session.close();
//        sessionFactory.close();
    }
}
