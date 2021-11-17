package main.plateau.ennemies.sorciers;

import main.plateau.ennemies.Ennemi;

abstract public class Sorciers extends Ennemi {
    public Sorciers(String type) {
        this.setType(type);
    }
    public Sorciers() {
        this("sorcier");
    }
}
