package game.plateau.armes;

import game.personnages.Guerrier;
import game.personnages.Personnage;
import game.plateau.setcases.Case;
import game.plateau.armes.swords.CrystalSword;

import java.util.Scanner;

abstract public class Armes extends Case {
    private String name;
    private int atk;

    protected Armes(String name, int atk) {
        this.name = name;
        this.atk = atk;
    }


//    getters setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
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