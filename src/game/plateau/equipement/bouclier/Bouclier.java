package game.plateau.equipement.bouclier;

import game.plateau.setcases.Case;

abstract public class Bouclier extends Case {
    private String name;

    protected Bouclier(String name) {
        this.name = name;
    }

    //    getters setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "New shield:" + name;
    }
}

