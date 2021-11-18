package game.plateau.bouclier;

import game.personnages.Personnage;
import game.plateau.setcases.Case;

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
