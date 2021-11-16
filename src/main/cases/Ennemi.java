package main.cases;

public class Ennemi extends Case {
    private final String ennemi;

    public Ennemi(String ennemi) {
        this.ennemi = ennemi;
    }

    public String toString() {
        return ennemi;
    }
}
