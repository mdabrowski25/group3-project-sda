package pl.sdacademy.entity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class DummyCovidDao implements CovidDao {
    Country poland = new Country("Poland", "PL");
    Country germany = new Country("Germany", "GE");
    Country norway = new Country("Norway", "NO");
    List<Country> countries = Arrays.asList(
            poland,
            germany,
            norway
    );
    @Override
    public List<Country> getCountries() {
        return countries;
    }

    @Override
    public DayData getAndSaveCurrentDataByCountry(String countryShortcut) {
        return null;
    }


    public List<DayData> getDataByCountry(int id) {
        return Arrays.asList(
                new DayData(LocalDate.now(),
                        poland, 2344, 1234, 234,
                        34566, 443, 4567),
                new DayData(LocalDate.now(),
                        poland, 2344, 1234, 234,
                        34566, 443, 4567),
                new DayData(LocalDate.now(),
                        poland, 2344, 1234, 234,
                        34566, 443, 4567)
        );
    }

    public DayData getCurrentDataByCountry(int id) {
        return
                new DayData(LocalDate.now(), germany, 2344, 1234, 234,
                        34566, 443, 4567);
    }

    @Override
    public DayData getCurrentWorldData() {
       return new DayData(LocalDate.now(),
                        poland, 2344, 1234, 234,
                        34566, 443, 4567);
    }

    @Override
    public void storeData(List<Country> countries) {

    }
}
