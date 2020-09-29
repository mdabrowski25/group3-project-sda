package pl.sdacademy.apiCore;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.sdacademy.entity.ApiEntityDataProvider;
import pl.sdacademy.entity.Country;

import java.util.List;

public class Main {
    public static void main(String[] args) {

//        ApiDataProvider<WorldCoronaPeople> apiDataProvider = new ApiDataProvider<>();
//        WorldCoronaPeople worldCoronaPeople = apiDataProvider.get("https://api.thevirustracker.com/free-api?global=stats", WorldCoronaPeople.class);
//        System.out.println(worldCoronaPeople.toString());
//        System.out.println(worldCoronaPeople.getResult().getTotal_active_cases());
//
//
//        ApiDataProvider<CountryCoronaPeople> apiDataProvider2 = new ApiDataProvider<>();
//        CountryCoronaPeople countryCoronaPeople = apiDataProvider2.get("https://api.covid19api.com/summary", CountryCoronaPeople.class);
//        System.out.println(countryCoronaPeople.getCountries().toString());

        ApiEntityDataProvider apiEntityDataProvider = new ApiEntityDataProvider();
        SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory("hibernate.cfg.xml");
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Country> countryList = apiEntityDataProvider.load();
        for (Country country : countryList) {
            session.save(country);
        }
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
