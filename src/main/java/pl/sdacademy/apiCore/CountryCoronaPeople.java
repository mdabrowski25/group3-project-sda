package pl.sdacademy.apiCore;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CountryCoronaPeople extends CoronaPeople implements Serializable {
    @SerializedName("Countries")
    List<CovidCountryObject> countries = new ArrayList<>();

    public List<CovidCountryObject> getCountries() {
        return countries;
    }

    public CovidCountryObject getOneCountry(String countryShortcut){
        List<CovidCountryObject> collect = countries.stream()
                .filter((e1) -> e1.getCountryCode().equals(countryShortcut.toUpperCase()))
                .collect(Collectors.toList());
        if (collect.isEmpty()){
            throw new RuntimeException("Brak obiektu kraju na liscie");
        } else {
            return collect.get(0);
        }
    }

    @Override
    public String toString() {
        return "CountryCoronaPeople{" +
                "countries=" + countries +
                '}';
    }

    public static class CovidCountryObject {
        @SerializedName("Country")
        private String countryName;
        @SerializedName("CountryCode")
        private String countryCode;
        @SerializedName("NewConfirmed")
        private Integer newConfirmed;
        @SerializedName("TotalConfirmed")
        private Integer totalConfirmed;
        @SerializedName("NewDeaths")
        private Integer newDeaths;
        @SerializedName("TotalDeaths")
        private Integer totalDeaths;
        @SerializedName("NewRecovered")
        private Integer newRecovered;
        @SerializedName("TotalRecovered")
        private Integer totalRecovered;

        public String getCountryName() {
            return countryName;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public Integer getNewConfirmed() {
            return newConfirmed;
        }

        public Integer getTotalConfirmed() {
            return totalConfirmed;
        }

        public Integer getNewDeaths() {
            return newDeaths;
        }

        public Integer getTotalDeaths() {
            return totalDeaths;
        }

        public Integer getNewRecovered() {
            return newRecovered;
        }

        public Integer getTotalRecovered() {
            return totalRecovered;
        }

        @Override
        public String toString() {
            return "CovidCountryObject{" +
                    "countryName='" + countryName + '\'' +
                    ", countryCode='" + countryCode + '\'' +
                    ", newConfirmed=" + newConfirmed +
                    ", totalConfirmed=" + totalConfirmed +
                    ", newDeaths=" + newDeaths +
                    ", totalDeaths=" + totalDeaths +
                    ", newRecovered=" + newRecovered +
                    ", totalRecovered=" + totalRecovered +
                    '}';
        }
    }
}
