package game.plateau.ennemies.dragons;

import game.plateau.ennemies.Ennemi;

abstract public class Dragons extends Ennemi {

    private String type;

    protected Dragons() {
        this("dragon",15,4);
    }

    protected Dragons(String type) {
        this("dragon",15,4);
        this.type = type;
    }

    protected Dragons(String race, int vie, int atk) {
       super(race,vie,atk);
    }

    @Override
    public String toString() {
        return type + "Dragons"+'\'';
    }
}
