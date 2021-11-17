package main.plateau.armes.swords;

import main.plateau.armes.Arme;

abstract class Swords extends Arme {
    private String name;

    public Swords(){
        this("Sword");
    }

    public Swords(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
