package game.plateau.armes.massues;

import game.plateau.armes.Armes;

abstract class Massues extends Armes {
    private String type;

    protected Massues(String type){
        this("Massue", 5);
        this.type = type;
    }


    protected Massues(String name, int atk) {
        super(name, atk);
    }
}
