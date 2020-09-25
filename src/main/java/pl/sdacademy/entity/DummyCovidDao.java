package pl.sdacademy.entity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class DummyCovidDao implements CovidDao {
    Country poland = new Country("Poland", "PL", 38_000_000);
    Country germany = new Country("Germany", "DE", 83_000_000);
    Country norway = new Country("Norway", "NO", 5_700_000);
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
    public List<DayData> getDataByCountryAndDateRange(int id, LocalDate from, LocalDate to) {
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

    @Override
    public DayData getCurrentDataByCountry(int id) {
        return
                new DayData(LocalDate.now(), germany, 2344, 1234, 234,
                        34566, 443, 4567);
    }

    @Override
    public List<DayData> getCurrentWorldData() {
       return Arrays.asList(
                new DayData(LocalDate.now(),
                        poland, 2344, 1234, 234,
                        34566, 443, 4567),
                new DayData(LocalDate.now(),
                        germany, 2344, 1234, 234,
                        34566, 443, 4567),
                new DayData(LocalDate.now(),
                        norway, 2344, 1234, 234,
                        34566, 443, 4567)
        );
    }

    @Override
    public void storeData(List<Country> countries) {

    }
}
