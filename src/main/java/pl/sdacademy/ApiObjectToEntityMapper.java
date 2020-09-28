package pl.sdacademy;

import pl.sdacademy.entity.Country;

import java.util.ArrayList;
import java.util.List;

public class ApiObjectToEntityMapper {
    public List<Country> map(){
        ApiDataProvider<CountryCoronaPeople> apiDataProvider2 = new ApiDataProvider<>();
        CountryCoronaPeople countryCoronaPeople =
                apiDataProvider2.get("https://api.covid19api.com/summary", CountryCoronaPeople.class);

        List<CountryCoronaPeople.CovidCountryObject> countries = countryCoronaPeople.getCountries();
        List<Country> result = new ArrayList<>();
        for (int i = 0; i < countries.size(); i++) {
            result.add(new Country(countries.get(i).getCountryName(), countries.get(i).getCountryCode()));
        }
        return result;
    }
}
