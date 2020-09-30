package pl.sdacademy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String shortname;

    public Country() {
    }

    public Country(String name, String shortname) {
        this.name = name;
        this.shortname = shortname;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getShortname() {
        return shortname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortname='" + shortname + '\'' +
                ", population=" + '}';
    }
}
