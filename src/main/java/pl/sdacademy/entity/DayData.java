package pl.sdacademy.entity;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class DayData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    @OneToOne
    private Country country;
    private int total_cases;
    private int total_new_cases_today;
    private int total_active_cases;
    private int total_new_deaths_today;
    private int total_deaths;
    private int total_recovered;

    public DayData() {
    }

    public DayData(LocalDate date, Country country, int total_cases,
                   int total_new_cases_today, int total_active_cases, int total_new_deaths_today,
                   int total_deaths, int total_recovered) {
        this.date = date;
        this.country = country;
        this.total_cases = total_cases;
        this.total_new_cases_today = total_new_cases_today;
        this.total_active_cases = total_active_cases;
        this.total_new_deaths_today = total_new_deaths_today;
        this.total_deaths = total_deaths;
        this.total_recovered = total_recovered;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Country getCountry() {
        return country;
    }

    public int getTotal_cases() {
        return total_cases;
    }

    public int getTotal_new_cases_today() {
        return total_new_cases_today;
    }

    public int getTotal_active_cases() {
        return total_active_cases;
    }

    public int getTotal_new_deaths_today() {
        return total_new_deaths_today;
    }

    public int getTotal_deaths() {
        return total_deaths;
    }

    public int getTotal_recovered() {
        return total_recovered;
    }

    @Override
    public String toString() {
        return "DayData{" +
                "id=" + id +
                ", date=" + date +
                ", country=" + country +
                ", total_cases=" + total_cases +
                ", total_new_cases_today=" + total_new_cases_today +
                ", total_active_cases=" + total_active_cases +
                ", total_new_deaths_today=" + total_new_deaths_today +
                ", total_deaths=" + total_deaths +
                ", total_recovered=" + total_recovered +
                '}';
    }
}
