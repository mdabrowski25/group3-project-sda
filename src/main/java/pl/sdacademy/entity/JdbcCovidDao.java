package pl.sdacademy.entity;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcCovidDao implements CovidDao{
private Connection connection;

public JdbcCovidDao(Connection connection) {
    this.connection = connection;
}

    @Override
    public List<Country> getCountries() {
                try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("" +
                    "SELECT 'name, shortname, population'" +
                    "FROM" +
                    "country");
            List<Country> allCountries = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String shortname = resultSet.getString("shortname");
                int population = resultSet.getInt("population");
                allCountries.add(new Country(id, name, shortname, population));
            }
            return allCountries;
        } catch (SQLException e) {
            throw new RuntimeException("Błąd", e);
        }
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
