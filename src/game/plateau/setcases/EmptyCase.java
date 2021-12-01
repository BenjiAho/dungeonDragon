package game.plateau.setcases;

import game.personnages.Personnage;

public class EmptyCase implements Case {
    @Override
    public String toString() {
        return "This an empty case";
    }

    @Override
    public void interaction(Personnage hero) {

    }
}
