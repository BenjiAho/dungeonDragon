package game.plateau.equipement.armes.massues;

import game.personnages.Guerrier;
import game.personnages.Personnage;
import game.plateau.equipement.armes.Armes;

import java.util.Scanner;

abstract class Massues extends Armes {
    private String type;

    protected Massues(String type){
        this("Mace", 5);
        this.type = type;
    }


    protected Massues(String name, int atk) {
        super(name, atk);
    }

    @Override
    public String toString() {
        return type + "Mace";
    }

    protected void displayWeapon() {
        System.out.println("Vous avez trouver "+ this.type +this.getName() +"!\n" + "L'equiper?\n" + " 1-Oui\n" + " 2-Non");
    }

}
