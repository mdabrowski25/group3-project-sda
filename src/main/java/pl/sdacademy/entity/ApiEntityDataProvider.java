package pl.sdacademy.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.sdacademy.apiCore.ApiDataProvider;
import pl.sdacademy.apiCore.CountryCoronaPeople;
import pl.sdacademy.apiCore.SessionFactoryProvider;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ApiEntityDataProvider implements EntityDataProvider {
  ApiDataProvider<CountryCoronaPeople> apiDataProvider = new ApiDataProvider<>();
//    ApiEntityDataProvider apiEntityDataProvider = new ApiEntityDataProvider();
    @Override
    public List<Country> load() {
        return ApiObjectToEntityMapper.map();
    }

    public DayData returnAndSaveCurrentDayDataIntoDB(String countryShortcut){
        CountryCoronaPeople countryCoronaPeople =
                apiDataProvider.get("https://api.covid19api.com/summary", CountryCoronaPeople.class);
        DayData dayData = new DayData();
        CountryCoronaPeople.CovidCountryObject oneCountry = countryCoronaPeople.getOneCountry(countryShortcut);
        List<Country> countries = this.load();
        List<Country> collect = countries.stream()
                .filter((e1) -> e1.getShortname().equals(countryShortcut))
                .collect(Collectors.toList());
        dayData.setCountry(collect.get(0));
        dayData.setTotal_cases(oneCountry.getTotalConfirmed());
        dayData.setTotal_new_cases_today(oneCountry.getNewConfirmed());
        dayData.setTotal_new_deaths_today(oneCountry.getNewDeaths());
        dayData.setTotal_deaths(oneCountry.getTotalDeaths());
        dayData.setTotal_recovered(oneCountry.getTotalRecovered());
        dayData.setNew_recovered(oneCountry.getNewRecovered());
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        session.save(dayData);
//        transaction.commit();
//        session.close();
        return dayData;
    }

    public static class ApiObjectToEntityMapper {
        private static List<Country> map() {
            ApiDataProvider<CountryCoronaPeople> apiDataProvider = new ApiDataProvider<>();
            CountryCoronaPeople countryCoronaPeople =
                    apiDataProvider.get("https://api.covid19api.com/summary", CountryCoronaPeople.class);

            List<CountryCoronaPeople.CovidCountryObject> countries = countryCoronaPeople.getCountries();
            return countries.stream()
                    .map(covidCountryObject -> new Country(covidCountryObject.getCountryName(), covidCountryObject.getCountryCode()))
                    .collect(Collectors.toList());
        }

    }
}