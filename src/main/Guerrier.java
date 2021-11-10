package main;

import java.util.*;

public class Guerrier extends Personnage {
    //3constructeurs sans paramètres, avec nom et avec nom/image/niveau de vie/force d'attaque

    private String bouclier;
    private Arme arme;


    public String toString() {
        return nomPerso + ": with " + life + " life points and " + atk + " attack's points. Weapon : " + arme + " , shield:" + bouclier + "\n__\n";
    }

    public Guerrier(String nomPerso, int life, int atk, String arme, String bouclier) {
        this.nomPerso = nomPerso;
        this.life = life;
        this.atk = atk;
        this.arme = new Arme(arme);
        this.bouclier = bouclier;
    }

    public Guerrier(String nomPerso) {
        this(nomPerso, 5, 5, "massue de ses morts! ", "Bouclier de son grand mort! ");
    }

    public Guerrier() {
        this("Garrosh", 10, 10, "hâche de ses morts! ", "Bouclier en tête de bouc! ");
    }


    public String getNomPerso() {
        return nomPerso;
    }




    public String getbouclier() {
        return bouclier;
    }

    public void setBouclier(String bouclier) {
        this.bouclier = bouclier;
    }

    public int getLifeLvl() {
        return life;
    }



    public int getAtk() {
        return atk;
    }



    public void selectionWarrior() {
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
                    "\nLife points: " + life
                    + "\natk points: " + atk
                    + "\nweapon: " + arme
                    + "\nshield: " + bouclier);

            System.out.println("Change hero attributes: \nA for life points\nB for atk points\nC for weapon" + "\nD for shield" + "\nX exit menu" + "\n___________________________");
            String warriorChoices = sc.next();


            switch (warriorChoices.toUpperCase()) {

                case "A":
                    boolean validLife = false;
                    do{
                        System.out.println("enter life between 5 and 10");
                        int life = sc.nextInt();
                        if(life >= 5 && life <= 10){
                            this.setLifeLvl(life);
                            validLife = true;
                        }else{
                            System.out.println("enter valid value *");
                        }
                    }while(!validLife);
                    System.out.println("___________________________"
                            + "\nHero's name: " + nomPerso +
                            "\nLife points: " + life
                            + "\natk points: " + atk
                            + "\nweapon: " + arme
                            + "\nshield: " + bouclier
                            + "\n___________________________");
                    break;
                case "B":
                    boolean validAtk = false;
                    do{
                        System.out.println("enter atk between 5 and 10");
                        int atk = sc.nextInt();
                        if(atk >= 5 && atk <= 10){
                            this.setLifeLvl(atk);
                            validAtk = true;
                        }else{
                            System.out.println("enter valid value *");
                        }
                    }
                    while (!validAtk);
                    System.out.println("___________________________"
                            + "\nHero's name: " + nomPerso
                            + "\nLife points: " + this.life
                            + "\natk points: " + atk
                            + "\nweapon: " + arme
                            + "\nshield: " + bouclier
                            + "\n___________________________");
                    break;
                case "C":
                    System.out.println("set weapon: ");
                    String armes = sc.next();
                    System.out.println("___________________________"
                            + "\nHero's name: " + nomPerso
                            + "\nLife points: " + this.life
                            + "\natk points: " + this.atk
                            + "\nweapon: " + armes
                            + "\nshield: " + bouclier
                            + "\n___________________________");
                    this.arme = new Arme(armes);
                    break;
                case "D":
                    System.out.println("set Shield: ");
                    String bouclier = sc.next();
                    this.setBouclier(bouclier);
                    System.out.println("___________________________"
                            + "\nHero's name: " + nomPerso
                            + "\nLife points: " + this.life
                            + "\natk points: " + this.atk
                            + "\nweapon: " + this.arme
                            + "\nshield: " + bouclier
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




