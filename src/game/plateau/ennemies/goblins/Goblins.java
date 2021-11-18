package game.plateau.ennemies.goblins;

import game.plateau.ennemies.Ennemi;

abstract public class Goblins extends Ennemi {
    private String name;

    protected Goblins() {
        this("Goblin",15,4);
    }

    protected Goblins(String name){
        this("goblin", 9, 2);
        this.name = name;
    }

    protected Goblins(String race, int life, int atk) {
        super(race, life, atk);
    }

    @Override
    public String toString() {
        return "name: " + name + '\'';
    }
}
