package main.plateau.ennemies.sorciers;

import main.plateau.ennemies.Ennemi;

abstract public class Sorciers extends Ennemi {
    private String name;

    protected Sorciers() {
        this("Sorcier",15,4);
    }

    protected Sorciers(String name){
        this("Sorcier", 9, 2);
        this.name = name;
    }

    protected Sorciers(String race, int life, int atk) {
        super(race, life, atk);
    }


}
