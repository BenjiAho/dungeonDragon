package game.plateau.equipement.armes.massues;

import game.personnages.Guerrier;
import game.personnages.Personnage;
import game.plateau.equipement.armes.swords.IcySword;

import java.util.Scanner;

public class WoodenMace extends Massues{

    public WoodenMace(){
        super("Wooden");
    }

    public void interaction(Personnage hero) {
        if(hero instanceof Guerrier){
            Scanner scanner = new Scanner(System.in);

            System.out.println("Vous avez trouver une Icysword!\n" + "L'equiper?\n" + " 1-Oui\n" + " 2-Non");
            int arme = scanner.nextInt();
            switch (arme){
                case 1:
                    ((Guerrier)hero).setArme(new WoodenMace());
                    break;
                case 2:
                    break;
            }

        }else {
            System.out.println("t baise faller prendre guerrier, CHEH!!!!");
        }

    }
}
