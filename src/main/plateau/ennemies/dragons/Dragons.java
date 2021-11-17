package main.plateau.ennemies.dragons;

import main.plateau.ennemies.Ennemi;

abstract public class Dragons extends Ennemi {
    private String type;

    protected Dragons(String type) {
        this.setType(type);
    }
    protected Dragons() {
        this("dragon");
    }

    @Override
    public String toString() {
        return this.type;
    }

}
