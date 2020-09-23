package pl.sdacademy;

public class CoronaPeople {
    Integer infected;
    Integer recovered;
    Integer deceased;

    public CoronaPeople(Integer infected, Integer recovered, Integer deceased) {
        this.infected = infected;
        this.recovered = recovered;
        this.deceased = deceased;
    }

    public CoronaPeople() {
    }

    public Integer getRecovered() {
        return recovered;
    }

    public Integer getInfected() {
        return infected;
    }

    public Integer getDeceased() {
        return deceased;
    }

    @Override
    public String toString() {
        return "CoronaPeople{" +
                "infected=" + infected +
                ", recovered=" + recovered +
                ", deceased=" + deceased +
                '}';
    }
}
