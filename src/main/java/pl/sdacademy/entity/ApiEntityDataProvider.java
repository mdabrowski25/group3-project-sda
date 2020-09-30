package pl.sdacademy.entity;

import pl.sdacademy.apiCore.ApiDataProvider;
import pl.sdacademy.apiCore.CountryCoronaPeople;

import java.util.List;
import java.util.stream.Collectors;

public class ApiEntityDataProvider implements EntityDataProvider {

    @Override
    public List<Country> load() {
        return ApiObjectToEntityMapper.map();
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