package game.plateau.equipement.potions;

import game.personnages.Magicien;
import game.personnages.Personnage;

import java.util.Scanner;

public class BasicPotion extends Potion {

    public BasicPotion() {
        super("Small health potion", 2);
    }


    protected void displayPotion() {
        System.out.println("Vous avez trouver " + this.getName() + this.getLife() + "!\n" + "L'equiper?\n" + " 1-Oui\n" + " 2-Non");
    }

}
