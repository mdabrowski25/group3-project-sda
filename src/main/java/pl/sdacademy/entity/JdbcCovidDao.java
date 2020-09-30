package pl.sdacademy.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import pl.sdacademy.apiCore.SessionFactoryProvider;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

public class JdbcCovidDao implements CovidDao {
    private Connection connection;
    private Country country;


    public JdbcCovidDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Country> getCountries() {
        SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory("hibernate.cfg.xml");
        Session session = sessionFactory.openSession();
        Query<Country> query = session.createQuery("SELECT FROM country", Country.class);
        List<Country> allCountries = query.getResultList();
        return allCountries;
    }


    @Override
    public List<DayData> getDataByCountryAndDateRange(int idOfSearchedCountry, LocalDate from, LocalDate to) {
        SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory("hibernate.cfg.xml");
        Session session = sessionFactory.openSession();
        Query<DayData> query = session.createQuery("SELECT FROM daydata WHERE " +
                "country_id = " + idOfSearchedCountry + " AND date is between ( " + from +
                ", " + to + " )", DayData.class);
        List<DayData> dataByCountryAndDateRange = query.getResultList();
        return dataByCountryAndDateRange;
    }

    @Override
    public DayData getCurrentDataByCountry(int idOfSearchedCountry) {
        SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory("hibernate.cfg.xml");
        Session session = sessionFactory.openSession();
        Query<DayData> query = session.createQuery("SELECT * FROM daydata WHERE country.id = " +
                idOfSearchedCountry, DayData.class);
        DayData currentDataByCountry = query.getSingleResult();
        return currentDataByCountry;
    }

    @Override
    public List<DayData> getCurrentWorldData() {
        SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory("hibernate.cfg.xml");
        Session session = sessionFactory.openSession();
        Query<DayData> query = session.createQuery("SELECT * FROM daydata WHERE date is " +
                LocalDate.now(), DayData.class);
        List<DayData> currentWorldData = query.getResultList();
        return currentWorldData;
    }

    @Override
    public void storeData(List<Country> countries) {

    }
}


