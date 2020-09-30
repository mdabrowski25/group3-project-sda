package pl.sdacademy.entity;

import java.util.List;

public class DbCovidDaoTests {
    public static void main(String[] args) {
        DbCovidDao dbCovidDao = new DbCovidDao();
        List<Country> countries = dbCovidDao.getCountries();
        System.out.println(countries.toString());
    }
}