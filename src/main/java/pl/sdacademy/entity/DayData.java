package pl.sdacademy.entity;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class DayData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    @OneToOne (cascade = CascadeType.PERSIST)
    private Country country;
    private Integer total_cases;
    private Integer total_new_cases_today;
    private Integer total_new_deaths_today;
    private Integer total_deaths;
    private Integer total_recovered;
    private Integer new_recovered;

    public DayData() {
    }

    public DayData(LocalDate date, Country country, Integer total_cases,
                   Integer total_new_cases_today, Integer total_new_deaths_today,
                   Integer total_deaths, Integer total_recovered, Integer new_recovered) {
        this.date = date;
        this.country = country;
        this.total_cases = total_cases;
        this.total_new_cases_today = total_new_cases_today;
        this.new_recovered = new_recovered;
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

    public Integer getTotal_cases() {
        return total_cases;
    }

    public Integer getTotal_new_cases_today() {
        return total_new_cases_today;
    }

    public Integer getTotal_new_deaths_today() {
        return total_new_deaths_today;
    }

    public Integer getTotal_deaths() {
        return total_deaths;
    }

    public Integer getTotal_recovered() {
        return total_recovered;
    }

    public Integer getNew_recovered() {
        return new_recovered;
    }

    @Override
    public String toString() {
        return "DayData{" +
                "id=" + id +
                ", date=" + date +
                ", country=" + country +
                ", total_cases=" + total_cases +
                ", total_new_cases_today=" + total_new_cases_today +
                ", total_new_deaths_today=" + total_new_deaths_today +
                ", total_deaths=" + total_deaths +
                ", total_recovered=" + total_recovered +
                ", new_recovered=" + new_recovered +
                '}';
    }
}
