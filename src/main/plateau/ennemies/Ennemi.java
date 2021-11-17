package main.plateau.ennemies;

import main.personnages.Personnage;
import main.plateau.Case;

abstract public class Ennemi extends Case {
    private  String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void interaction(Personnage hero) {

    }
}
