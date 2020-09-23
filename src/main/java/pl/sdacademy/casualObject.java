package pl.sdacademy;

public class casualObject {
    Integer infected;
    Integer secondInt;

    public casualObject(Integer infected, Integer secondInt) {
        this.infected = infected;
        this.secondInt = secondInt;
    }

    public casualObject() {
    }

    public Integer getInfected() {
        return infected;
    }

    public void setInfected(Integer infected) {
        this.infected = infected;
    }

    public Integer getSecondInt() {
        return secondInt;
    }

    public void setSecondInt(Integer secondInt) {
        this.secondInt = secondInt;
    }

    @Override
    public String toString() {
        return "casualObject{" +
                "infected=" + infected +
                ", secondInt=" + secondInt +
                '}';
    }
}
