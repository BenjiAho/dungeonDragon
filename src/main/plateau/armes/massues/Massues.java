package main.plateau.armes.massues;

import main.plateau.armes.Arme;

abstract class Massues extends Arme {
    private String name;

    public Massues(){
        this("Massue");
    }

    protected Massues(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
