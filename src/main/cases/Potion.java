package main.cases;

public class Potion extends Case{
    private final String potion;

    public Potion(String potion) {
        this.potion = potion;
    }

    public String toString() {
        return potion;
    }
}
