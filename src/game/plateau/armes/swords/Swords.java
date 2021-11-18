package game.plateau.armes.swords;

import game.plateau.armes.Armes;

abstract class Swords extends Armes {
    private String type;


    protected Swords(String type){
        this("Sword", 5);
        this.type = type;
    }


    protected Swords(String name, int atk) {
        super(name, atk);
    }

    @Override
    public String toString() {
        return type +"Sword"+ '\'';
    }
}
