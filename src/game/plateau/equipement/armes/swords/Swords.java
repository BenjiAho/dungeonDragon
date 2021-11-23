package game.plateau.equipement.armes.swords;

import game.personnages.Guerrier;
import game.personnages.Personnage;
import game.plateau.equipement.armes.Armes;

import java.util.Scanner;

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

    protected void displayWeapon() {
        System.out.println("Vous avez trouver "+ this.type +this.getName() +"!\n" + "L'equiper?\n" + " 1-Oui\n" + " 2-Non");
    }

}
