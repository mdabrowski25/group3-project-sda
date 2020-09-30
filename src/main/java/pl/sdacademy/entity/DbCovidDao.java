package pl.sdacademy.entity;


import org.hibernate.SessionFactory;
import pl.sdacademy.apiCore.ApiDataProvider;
import pl.sdacademy.apiCore.SessionFactoryProvider;
import pl.sdacademy.apiCore.WorldCoronaPeople;

import java.time.LocalDate;
import java.util.List;

public class DbCovidDao implements CovidDao {
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory("hibernate.cfg.xml");
    ApiEntityDataProvider apiEntityDataProvider = new ApiEntityDataProvider();
    ApiDataProvider<WorldCoronaPeople> apiDataProvider = new ApiDataProvider<>();

    @Override
    public List<Country> getCountries() {
        return apiEntityDataProvider.load();
    }

    @Override
    public DayData getAndSaveCurrentDataByCountry(String countryShortcut) {
        return apiEntityDataProvider.returnAndSaveCurrentDayDataIntoDB(countryShortcut);
    }

    @Override
    public DayData getCurrentWorldData() {
        WorldCoronaPeople worldCoronaPeople =
                apiDataProvider.get("https://api.thevirustracker.com/free-api?global=stats", WorldCoronaPeople.class);
        WorldCoronaPeople.WorldObject result = worldCoronaPeople.getResult();
        DayData dayData = new DayData();
        dayData.setDate(LocalDate.now());
        dayData.setTotal_cases(result.getTotal_cases());
        dayData.setTotal_new_cases_today(result.getTotal_new_cases_today());
        dayData.setTotal_new_deaths_today(result.getTotal_new_deaths_today());
        dayData.setTotal_deaths(result.getTotal_deaths());
        dayData.setTotal_recovered(result.getTotal_recovered());
        dayData.setNew_recovered(dayData.getNew_recovered());
        return dayData;
    }

    @Override
    public void storeData(List<Country> countries) {

    }
}
