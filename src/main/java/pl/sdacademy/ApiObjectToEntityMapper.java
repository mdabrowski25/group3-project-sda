package pl.sdacademy;

import pl.sdacademy.entity.Country;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ApiObjectToEntityMapper {
    public List<Country> map() {
        ApiDataProvider<CountryCoronaPeople> apiDataProvider2 = new ApiDataProvider<>();
        CountryCoronaPeople countryCoronaPeople =
                apiDataProvider2.get("https://api.covid19api.com/summary", CountryCoronaPeople.class);

        List<CountryCoronaPeople.CovidCountryObject> countries = countryCoronaPeople.getCountries();
        List<Country> result = new ArrayList<>();
        for (CountryCoronaPeople.CovidCountryObject country : countries) {
            result.add(new Country(country.getCountryName(), country.getCountryCode()));
        }

        //drugie rozwiazanie
        List<Country> result2 = Collections.singletonList((Country) List.copyOf(countries));
        return result;
    }
}
