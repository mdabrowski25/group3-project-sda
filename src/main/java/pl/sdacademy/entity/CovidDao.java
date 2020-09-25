package pl.sdacademy.entity;

import java.time.LocalDate;
import java.util.List;

public interface CovidDao {
    List<Country> getCountries();
    List<DayData> getDataByCountryAndDateRange(int id, LocalDate from, LocalDate to);
    DayData getCurrentDataByCountry(int id);
    List<DayData> getCurrentWorldData();
    void storeData(List<Country> countries);
}
