package pl.sdacademy.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pl.sdacademy.apiCore.SessionFactoryProvider;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

import static org.hibernate.hql.internal.antlr.HqlTokenTypes.FROM;

public class JdbcCovidDao implements CovidDao {
    private Connection connection;
    private Country country;
    private final SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory("hibernate.cfg.xml");

    public JdbcCovidDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Country> getCountries() {
        Session session = sessionFactory.openSession();
        Query<Country> query = session.createQuery("SELECT a FROM Country a ORDER by a.name", Country.class);
        sessionFactory.close();
        session.close();
        return query.getResultList();
    }


    @Override
    public List<DayData> getDataByCountryAndDateRange(int idOfSearchedCountry, LocalDate from, LocalDate to) {
        Session session = sessionFactory.openSession();
        Query<DayData> query = session.createQuery("SELECT a FROM Daydata a WHERE a.country.id =  " +
                idOfSearchedCountry + " AND date is between ( " + from +
                ", " + to + " )", DayData.class);
        sessionFactory.close();
        session.close();
        return query.getResultList();
    }

    @Override
    public DayData getCurrentDataByCountry(int idOfSearchedCountry) {
        Session session = sessionFactory.openSession();
        Query<DayData> query = session.createQuery("SELECT a FROM DayData a WHERE a.country.id" +
                idOfSearchedCountry + "date is " + LocalDate.now(), DayData.class);
        sessionFactory.close();
        session.close();
        return query.getSingleResult();
    }

    @Override
    public List<DayData> getCurrentWorldData() {
        Session session = sessionFactory.openSession();
        Query<DayData> query = session.createQuery("SELECT a FROM DayData a WHERE date is " +
                LocalDate.now(), DayData.class);
        sessionFactory.close();
        session.close();
        return query.getResultList();
    }

    @Override
    public void storeData(List<Country> countries) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("DELETE FROM DayData")
                .executeUpdate();
        transaction.commit();

        session.close();


    }
}


