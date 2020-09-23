package pl.sdacademy;

public class WorldCoronaPeople {
    Integer infected;
    Integer recovered;
    Integer deceased;

    public WorldCoronaPeople(Integer infected, Integer recovered, Integer deceased) {
        this.infected = infected;
        this.recovered = recovered;
        this.deceased = deceased;
    }

    public WorldCoronaPeople() {
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
        return "WorldCoronaPeople{" +
                "infected=" + infected +
                ", recovered=" + recovered +
                ", deceased=" + deceased +
                '}';
    }
}
