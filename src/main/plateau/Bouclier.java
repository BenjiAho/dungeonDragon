package main.plateau;

import main.personnages.Personnage;

public class Bouclier extends Case {
    private final String bouclier;

    public Bouclier(String bouclier) {
        this.bouclier = bouclier;
    }

    public String toString() {
        return bouclier;
    }

    @Override
    public void interaction(Personnage hero) {

    }
}
