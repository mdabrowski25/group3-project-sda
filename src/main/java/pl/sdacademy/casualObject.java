package pl.sdacademy;

public class casualObject {
    Integer infected;
    Integer deceased;

    public casualObject(Integer infected, Integer deceased) {
        this.infected = infected;
        this.deceased = deceased;
    }

    public casualObject() {
    }

    public Integer getInfected() {
        return infected;
    }

    public void setInfected(Integer infected) {
        this.infected = infected;
    }

    public Integer getDeceased() {
        return deceased;
    }

    public void setDeceased(Integer deceased) {
        this.deceased = deceased;
    }

    @Override
    public String toString() {
        return "casualObject{" +
                "infected=" + infected +
                ", deceased=" + deceased +
                '}';
    }
}
