package game.plateau.equipement.armes;

import game.personnages.Guerrier;
import game.personnages.Personnage;
import game.plateau.setcases.Case;
import game.plateau.equipement.armes.swords.CrystalSword;

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

    public void interaction(Personnage hero) {
//        Armes arme = null;
        if(hero instanceof Guerrier){
            Scanner scanner = new Scanner(System.in);

            displayWeapon();
            int weapon = scanner.nextInt();
            switch (weapon){
                case 1:
                    ((Guerrier)hero).setArme(this);
                    break;
                case 2:
                    break;
            }
        }else {
            System.out.println("Sorry you aren't a warrior");
        }
    }

     abstract protected void displayWeapon() ;


}