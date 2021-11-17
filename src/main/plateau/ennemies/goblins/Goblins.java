package main.plateau.ennemies.goblins;

import main.plateau.ennemies.Ennemi;

abstract public class Goblins extends Ennemi {
    public Goblins(String type) {
        this.setType(type);
    }
    public Goblins(){
        this("goblin");
    }

}
