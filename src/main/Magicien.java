package main;

import java.util.Scanner;

public class Magicien {
    //3constructeurs sans paramètres, avec nom et avec nom/image/niveau de vie/force d'attaque
    private String nomPerso;
    private int lifeLvl;
    private int atk;
    private Spell spell;
    private String potion;

    public String toString() {
        return nomPerso + ": with " + lifeLvl + " " + "points of life and" + " " + atk + " points of attack. Weapon : "+" "+spell+" "+"with "+potion+"\n__\n";
    }

    public Magicien(String nomPerso, int lifeLvl, int atk, String spell, String potion) {
        this.nomPerso = nomPerso;
        this.lifeLvl = lifeLvl;
        this.atk = atk;
        this.spell = new Spell(spell);
        this.potion = potion;
    }

    public Magicien(String nomPerso) {
        this(nomPerso, 5, 5, "! ", "Potion de son grand mort! ");
    }

    public Magicien() {
        this("GLANDALF", 6, 15, "Avacadabra", "Viagra Potion");
    }


    public String getNomPerso() {
        return nomPerso;
    }

    public void setNomPerso(String nomPerso) {
        this.nomPerso = nomPerso;
    }


    public String getPotion() {
        return potion;
    }

    public void setPotion(String potion) {
        this.potion = potion;
    }

    public int getLifeLvl() {
        return lifeLvl;
    }

    public void setLifeLvl(int lifeLvl) {
        this.lifeLvl = lifeLvl;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void selectionWizard() {
        //Reading values from user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of the warrior: ");
        String nomPerso = sc.nextLine();
        //Calling the setter and getter methods
        this.setNomPerso(nomPerso);
        boolean condition = true;
        while (condition) {
            System.out.println("___________________________"
                    + "\nHero's name: " + nomPerso +
                    "\nLife points: " + lifeLvl
                    + "\natk points: " + atk
                    + "\nspell: " + spell
                    + "\npotion: " + potion);

            System.out.println("Change hero attributes: \nA for life points\nB for atk points\nC for spell" + "\nD for potion"+ "\nX exit menu" + "\n___________________________");
            String wizardChoices = sc.next();



            switch (wizardChoices.toUpperCase()) {

                case "A":
                    System.out.println("set LifeLvl");
                    int lifeLvl = sc.nextInt();
                    this.setLifeLvl(lifeLvl);
                    System.out.println("___________________________"
                            + "\nHero's name: " + nomPerso +
                            "\nLife points: " + lifeLvl
                            + "\natk points: " + atk
                            + "\nspell: " + spell
                            + "\npotion: " + potion
                            + "\n___________________________");
                    break;
                case "B":
                    System.out.println("set ATK points");
                    int atk = sc.nextInt();
                    this.setAtk(atk);
                    System.out.println("___________________________"
                            + "\nHero's name: " + nomPerso
                            + "\nLife points: " + this.lifeLvl
                            + "\natk points: " + atk
                            + "\nspell: " + spell
                            + "\npotion: " + potion
                            + "\n___________________________");
                    break;
                case "C":
                    System.out.println("set spell: ");
                    String spells = sc.next();
                    System.out.println("___________________________"
                            + "\nHero's name: " + nomPerso
                            + "\nLife points: " + this.lifeLvl
                            + "\natk points: " + this.atk
                            + "\nspell: " + spells
                            + "\npotion: " + potion
                            + "\n___________________________");
                    this.spell = new Spell(spells);
                    break;
                case "D":
                    System.out.println("set potion: ");
                    String potion = sc.next();
                    this.setPotion(potion);
                    System.out.println("___________________________"
                            + "\nHero's name: " + nomPerso
                            + "\nLife points: " + this.lifeLvl
                            + "\natk points: " + this.atk
                            + "\nspell: " + this.spell
                            + "\npotion: " + potion
                            + "\n___________________________");
                    break;
                case "F":
                    System.out.println("End of game");
                    break;
                case "X":
                    System.out.println("Back to menu");
                    condition = false;
                    break;
            }
        }
    }
}




