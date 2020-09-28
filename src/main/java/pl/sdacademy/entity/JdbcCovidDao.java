package pl.sdacademy.entity;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcCovidDao implements CovidDao{


    @Override
    public List<Country> getCountries() {
        List<Country> allCountries = new ArrayList<>();
        return allCountries;
    }

    @Override
    public List<DayData> getDataByCountryAndDateRange(int id, LocalDate from, LocalDate to) {
        return null;
    }

    @Override
    public DayData getCurrentDataByCountry(int id) {
        return null;
    }

    @Override
    public List<DayData> getCurrentWorldData() {
        return null;
    }

    @Override
    public void storeData(List<Country> countries) {

    }
}
