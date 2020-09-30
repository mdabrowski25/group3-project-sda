package pl.sdacademy.entity;

import java.util.List;

public interface CovidDao {
    List<Country> getCountries();
    DayData getAndSaveCurrentDataByCountry(String countryShortcut);
    DayData getCurrentWorldData();
    void storeData(List<Country> countries);
}
