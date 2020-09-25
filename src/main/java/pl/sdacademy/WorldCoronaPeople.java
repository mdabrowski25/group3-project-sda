package pl.sdacademy;

import java.util.Arrays;

public class WorldCoronaPeople {
  WorldObject[] result = new WorldObject[1];

  public WorldObject getResult() {
    return result[0];
  }


  @Override
  public String toString() {
    return "WorldCoronaPeople{" +
            "result=" + Arrays.toString(result) +
            '}';
  }

  public static class WorldObject {
    private Integer total_cases;
    private Integer total_recovered;
    private Integer total_unresolved;
    private Integer total_deaths;
    private Integer total_new_cases_today;
    private Integer total_new_deaths_today;
    private Integer total_active_cases;
    private Integer total_serious_cases;
    private Integer total_affected_countries;

    public Integer getTotal_cases() {
      return total_cases;
    }

    public Integer getTotal_recovered() {
      return total_recovered;
    }

    public Integer getTotal_unresolved() {
      return total_unresolved;
    }

    public Integer getTotal_deaths() {
      return total_deaths;
    }

    public Integer getTotal_new_cases_today() {
      return total_new_cases_today;
    }

    public Integer getTotal_new_deaths_today() {
      return total_new_deaths_today;
    }

    public Integer getTotal_active_cases() {
      return total_active_cases;
    }

    public Integer getTotal_serious_cases() {
      return total_serious_cases;
    }

    public Integer getTotal_affected_countries() {
      return total_affected_countries;
    }

    @Override
    public String toString() {
      return "WorldObject{" +
              "total_cases=" + total_cases +
              ", total_recovered=" + total_recovered +
              ", total_unresolved=" + total_unresolved +
              ", total_deaths=" + total_deaths +
              ", total_new_cases_today=" + total_new_cases_today +
              ", total_new_deaths_today=" + total_new_deaths_today +
              ", total_active_cases=" + total_active_cases +
              ", total_serious_cases=" + total_serious_cases +
              ", total_affected_countries=" + total_affected_countries +
              '}';
    }
  }

}