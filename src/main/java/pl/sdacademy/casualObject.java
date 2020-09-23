package pl.sdacademy;

public class casualObject {
    private Integer infected;
    private Integer secondInt;

    public casualObject(Integer infected, Integer secondInt) {
        this.infected = infected;
        this.secondInt = secondInt;
    }

    public casualObject() {
    }

    public Integer getInfected() {
        return infected;
    }

    public Integer getSecondInt() {
        return secondInt;
    }

    @Override
    public String toString() {
        return "casualObject{" +
                "infected=" + infected +
                ", secondInt=" + secondInt +
                '}';
    }
}
