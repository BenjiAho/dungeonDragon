package main.plateau.armes;

import main.personnages.Guerrier;
import main.personnages.Personnage;
import main.plateau.Case;
import main.plateau.armes.swords.CrystalSword;

import java.util.Scanner;

abstract public class Arme extends Case {
    private Object arme;

    public Object getArme() {
        return arme;
    }

    public void setArme(Object arme) {
        this.arme = arme;
    }

    @Override
    public void interaction(Personnage hero) {
        if (hero instanceof Guerrier) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Vous avez trouver une epee!\n" + "L'equiper?\n" + " 1-Oui\n" + " 2-Non");
            int weapon = scanner.nextInt();
            switch (weapon) {
                case 1:
                    ((Guerrier) hero).setArme(new CrystalSword());
                    break;
                case 2:
                    break;
            }

        } else {
            System.out.println("t baise faller prendre guerrier, CHEH!!!!");
        }

    }
}