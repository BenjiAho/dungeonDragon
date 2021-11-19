package game;

import game.plateau.bouclier.Bouclier;
import game.plateau.setcases.HeroOutOfBoard;
import game.plateau.potions.BasicPotion;
import game.plateau.spells.FireBall;
import game.plateau.spells.Lightning;
import game.personnages.Guerrier;
import game.personnages.Magicien;
import game.personnages.Personnage;
import game.plateau.armes.massues.CrystalMace;
import game.plateau.armes.massues.IronMace;
import game.plateau.armes.massues.StoneMace;
import game.plateau.armes.swords.CrystalSword;
import game.plateau.armes.swords.IcySword;
import game.plateau.armes.swords.SteelSword;

import java.util.*;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);

//    private Game game = new Game();


    

    //    STRING TO INT
    public String getResult(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    public int getIntResult(String question) {
        try {
            return Integer.parseInt(getResult(question));
        } catch (Exception e) {
            return getIntResult(question);
        }
    }

    //    function to start game


    public Personnage wizardSelect(ArrayList<Magicien> wizards) {
        Personnage hero;
        System.out.println("Choisir un magicien ?");
        for (int i = 0; i < wizards.size(); i++) {
            System.out.println("Magicien : " + i + " : " + wizards.get(i));
        }
        System.out.println("entrer un chiffre");
        int selectWizard = scanner.nextInt();
        hero = wizards.get(selectWizard);
        System.out.println("Vous avez choisie : " + hero);
        return hero;
    }

    public Personnage warriorSelect(ArrayList<Guerrier> warriors) {
        Personnage hero;
        System.out.println("Choisir un guerrier :\n");
        for (int i = 0; i < warriors.size(); i++) {
            System.out.println("Guerrier : " + i + " : " + warriors.get(i));
        }
        System.out.println("entrer un chiffre");
        int selectWarrior = scanner.nextInt();
        hero = warriors.get(selectWarrior);
        System.out.println("Vous avez choisie : " + hero);
        return hero;
    }


    void displayExistingHeroes(ArrayList<Magicien> wizards, ArrayList<Guerrier> warriors) {
        System.out.println("Warriors List: \n" + warriors + "\nWizards List: \n" + wizards);
    }

    void mainMenu(ArrayList<Magicien> wizards, ArrayList<Guerrier> warriors, int selector1) {
        Personnage perso;
        switch (selector1) {
            case 1:
                System.out.println("Warrior selected");

                perso = new Guerrier();

                warriors.add((Guerrier) perso);
                selectionPersonnage(perso, true);
                break;
            case 2:
                System.out.println("Wizard selected");
                perso = new Magicien();
                wizards.add((Magicien) perso);
                selectionPersonnage(perso, false);
                break;
            case 3:
                System.out.println(warriors);
                System.out.println(wizards);
                break;
            case 4:
                System.out.println("End of game");
                break;
            default:
                System.out.println("Invalid choice, back to main menu");
        }
    }

    public void selectionPersonnage(Personnage perso, boolean isWarrior) {
        //Reading values from user
        Scanner sc = new Scanner(System.in);
        System.out.println(((isWarrior) ? "Enter name of the warrior: " : "Enter name of the wizard: "));

        //Calling the setter and getter methods
        String newNomPerso = sc.nextLine();
        if (!newNomPerso.equals("")) {
            perso.setNomPerso(newNomPerso);
        }

        boolean condition = true;
        while (condition) {
            System.out.println("___________________________"
                    + "\nHero's name: " + perso.getNomPerso() +
                    "\nLife points: " + perso.getLife()
                    + "\natk points: " + perso.getAtk()
                    + ((isWarrior)
                    ? "\nweapon: " + ((Guerrier) perso).getArme() + "\nshield: " + ((Guerrier) perso).getBouclier()
                    : "\nspell: " + ((Magicien) perso).getSpell() + "\npotion: " + ((Magicien) perso).getPotion()));


            int heroChoices = getIntResult("Change hero attributes: \n1 for life points\n2 for atk points" + ((isWarrior) ? "\n3 for weapon" + "\n4 for shield" : "\n3 for spell" + "\n4 for potion") + "\n5 exit menu" + "\n___________________________");

            switch (heroChoices) {

                case 1:
                    boolean validLife = false;
                    do {
                        int life = getIntResult("enter life between" + ((isWarrior) ? "5 and 10" : "3 and 6"));
                        if (((isWarrior) ? life >= 5 && life <= 10 : life >= 3 && life <= 6)) {
                            perso.setLifeLvl(life);
                            validLife = true;
                        } else {
                            System.out.println("enter valid value *");
                        }
                    } while (!validLife);
                    System.out.println("___________________________"
                            + "\nHero's name: " + perso.getNomPerso() +
                            "\nLife points: " + perso.getLife()
                            + "\natk points: " + perso.getAtk()
                            + ((isWarrior)
                            ? "\nweapon: " + ((Guerrier) perso).getArme() + "\nshield: " + ((Guerrier) perso).getBouclier()
                            : "\nspell: " + ((Magicien) perso).getSpell() + "\npotion: " + ((Magicien) perso).getPotion())
                            + "\n___________________________");
                    break;
                case 2:
                    boolean validAtk = false;
                    do {
                        int atk = getIntResult("enter atk between" + ((isWarrior) ? "5 and 10" : "8 and 15"));
                        if (((isWarrior) ? atk >= 5 && atk <= 10 : atk >= 8 && atk <= 15)) {
                            perso.setAtk(atk);
                            validAtk = true;
                        } else {
                            System.out.println("enter valid value *");
                        }
                    }
                    while (!validAtk);
                    System.out.println("___________________________"
                            + "\nHero's name: " + perso.getNomPerso() +
                            "\nLife points: " + perso.getLife()
                            + "\natk points: " + perso.getAtk()
                            + ((isWarrior)
                            ? "\nweapon: " + ((Guerrier) perso).getArme() + "\nshield: " + ((Guerrier) perso).getBouclier()
                            : "\nspell: " + ((Magicien) perso).getSpell() + "\npotion: " + ((Magicien) perso).getPotion())
                            + "\n___________________________");
                    break;
                case 3:
                    System.out.println((isWarrior)
                            ? "Pick a weapon: \n 1:Ironmace | 2: StoneMace | 3: CrystalSword | 4:SteelSword| 5:IcySword| 6:CrystalMace"
                            : "1: Lightning | 2: FireBall");


                    if (isWarrior) {
                        int armes = sc.nextInt();
                        switch (armes) {
                            case 1:
                                ((Guerrier) perso).setArme(new IronMace());
                                break;
                            case 2:
                                ((Guerrier) perso).setArme(new StoneMace());
                                break;
                            case 3:
                                ((Guerrier) perso).setArme(new CrystalSword());
                                break;
                            case 4:
                                ((Guerrier) perso).setArme(new SteelSword());
                                break;
                            case 5:
                                ((Guerrier) perso).setArme(new IcySword());
                                break;
                            case 6:
                                ((Guerrier) perso).setArme(new CrystalMace());
                                break;
                        }

                    } else {
                        int spells = sc.nextInt();

                        switch (spells) {
                            case 1:
                                ((Magicien) perso).setSpell(new Lightning());
                                break;
                            case 2:
                                ((Magicien) perso).setSpell(new FireBall());
                                break;
                        }
                    }

                    System.out.println("___________________________"
                            + "\nHero's name: " + perso.getNomPerso() +
                            "\nLife points: " + perso.getLife()
                            + "\natk points: " + perso.getAtk()
                            + ((isWarrior)
                            ? "\nweapon: " + ((Guerrier) perso).getArme() + "\nshield: " + ((Guerrier) perso).getBouclier()
                            : "\nspell: " + ((Magicien) perso).getSpell() + "\npotion: " + ((Magicien) perso).getPotion())
                            + "\n___________________________");
                    break;
                case 4:
                    System.out.println((isWarrior)
                            ? "Set shield: "
                            : "Set potion: ");

                    if (isWarrior) {
                        String boucliers = sc.next();
                        ((Guerrier) perso).setBouclier(new Bouclier(boucliers));
                    } else {

                        ((Magicien) perso).setPotion(new BasicPotion());
                    }
                    System.out.println("___________________________"
                            + "\nHero's name: " + perso.getNomPerso()
                            + "\nLife points: " + perso.getLife()
                            + "\natk points: " + perso.getAtk()
                            + ((isWarrior)
                            ? "\nweapon: " + ((Guerrier) perso).getArme() + "\nshield: " + ((Guerrier) perso).getBouclier()
                            : "\nspell: " + ((Magicien) perso).getSpell() + "\npotion: " + ((Magicien) perso).getPotion())
                            + "\n___________________________");
                    break;
                case 5:
                    System.out.println("Back to menu");
                    condition = false;
                    break;
            }
        }
    }

}