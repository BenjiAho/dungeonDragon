package main.plateau;

import main.personnages.Personnage;

public class EmptyCase extends main.plateau.Case {
    @Override
    public String toString() {
        return "This an empty case";
    }

    @Override
    public void interaction(Personnage hero) {

    }
}
