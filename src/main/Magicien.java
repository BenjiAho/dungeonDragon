package main;

import java.util.Objects;
import java.util.Scanner;

public class Magicien extends Personnage {
    //3constructeurs sans paramètres, avec nom et avec nom/image/niveau de vie/force d'attaque

    private Spell spell;
    private String potion;

    public String toString() {
        return nomPerso + ": with " + life + " " + "points of life and" + " " + atk + " points of attack. Weapon : " + " " + spell + " " + "with " + potion + "\n__\n";
    }

    public Magicien(String nomPerso, int life, int atk, String spell, String potion) {
        this.nomPerso = nomPerso;
        this.life = life;
        this.atk = atk;
        this.spell = new Spell(spell);
        this.potion = potion;
    }


    public Magicien() {
        this("GLANDALF", 6, 15, "Avacadabra", "Viagra Potion");
    }



    public Spell getSpell() {
        return spell;
    }
    public void setSpell(Spell spell) {
        this.spell = spell;
    }

    public String getPotion() {
        return potion;
    }
    public void setPotion(String potion) {
        this.potion = potion;
    }



//    public void selectionWizard() {
//        //Reading values from user
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter name of the wizard: ");
//
//        String newNomPerso = sc.nextLine();
//        if (!newNomPerso.equals("")) {
//            this.setNomPerso(newNomPerso);
//        }
//
//        //Calling the setter and getter methods
//
//        boolean condition = true;
//        while (condition) {
//            System.out.println("___________________________"
//                    + "\nHero's name: " + nomPerso +
//                    "\nLife points: " + life
//                    + "\natk points: " + atk
//                    + "\nspell: " + spell
//                    + "\npotion: " + potion);
//
//            System.out.println("Change hero attributes: \nA for life points\nB for atk points\nC for spell" + "\nD for potion" + "\nX exit menu" + "\n___________________________");
//            String wizardChoices = sc.next();
//
//
//            switch (wizardChoices.toUpperCase()) {
//
//                case "A":
//                    boolean validLife = false;
//                    do {
//                        System.out.println("enter life between 3 and 6");
//                        int life = sc.nextInt();
//                        if (life >= 3 && life <= 6) {
//                            this.setLifeLvl(life);
//                            validLife = true;
//                        } else {
//                            System.out.println("enter valid value *");
//                        }
//
//                    } while (!validLife);
//
//                    System.out.println("___________________________"
//                            + "\nHero's name: " + nomPerso +
//                            "\nLife points: " + life
//                            + "\natk points: " + atk
//                            + "\nspell: " + spell
//                            + "\npotion: " + potion
//                            + "\n___________________________");
//                    break;
//                case "B":
//                    boolean validAtk = false;
//                    do {
//                        System.out.println("enter atk between 8 and 15");
//                        int atk = sc.nextInt();
//                        if (atk >= 8 && atk <= 15) {
//                            this.setLifeLvl(atk);
//                            validAtk = true;
//                        } else {
//                            System.out.println("enter valid value *");
//                        }
//                    }
//                    while (!validAtk);
//                    System.out.println("set ATK points");
//
//                    this.setAtk(atk);
//                    System.out.println("___________________________"
//                            + "\nHero's name: " + nomPerso
//                            + "\nLife points: " + this.life
//                            + "\natk points: " + atk
//                            + "\nspell: " + spell
//                            + "\npotion: " + potion
//                            + "\n___________________________");
//                    break;
//                case "C":
//                    System.out.println("set spell: ");
//                    String spells = sc.next();
//                    System.out.println("___________________________"
//                            + "\nHero's name: " + nomPerso
//                            + "\nLife points: " + this.life
//                            + "\natk points: " + this.atk
//                            + "\nspell: " + spells
//                            + "\npotion: " + potion
//                            + "\n___________________________");
//                    this.spell = new Spell(spells);
//                    break;
//                case "D":
//                    System.out.println("set potion: ");
//                    String potion = sc.next();
//                    this.setPotion(potion);
//                    System.out.println("___________________________"
//                            + "\nHero's name: " + nomPerso
//                            + "\nLife points: " + this.life
//                            + "\natk points: " + this.atk
//                            + "\nspell: " + this.spell
//                            + "\npotion: " + potion
//                            + "\n___________________________");
//                    break;
//                case "F":
//                    System.out.println("End of game");
//                    break;
//                case "X":
//                    System.out.println("Back to menu");
//                    condition = false;
//                    break;
//            }
//        }
//    }
}




