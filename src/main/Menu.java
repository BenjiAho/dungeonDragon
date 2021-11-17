package main;

import main.plateau.Bouclier;
import main.plateau.Potion;
import main.plateau.potions.BasicPotion;
import main.plateau.spells.FireBall;
import main.plateau.spells.Lightning;
import main.plateau.spells.Spell;
import main.personnages.Guerrier;
import main.personnages.Magicien;
import main.personnages.Personnage;
import main.plateau.armes.massues.CrystalMace;
import main.plateau.armes.massues.IronMace;
import main.plateau.armes.massues.StoneMace;
import main.plateau.armes.swords.CrystalSword;
import main.plateau.armes.swords.IcySword;
import main.plateau.armes.swords.SteelSword;

import java.util.*;

public class Menu {
    public static void main(String[] args) {
        System.out.println("Starting game");
        Menu data = new Menu();
        data.mainMenu();
    }


    private final Scanner scanner = new Scanner(System.in);
    private final ArrayList<Guerrier> warriors = new ArrayList<>();
    private final ArrayList<Magicien> wizards = new ArrayList<>();
    public final int mapSize = 64;
    private Game game = new Game();


//    public void plateau() {
//        int[] num = new int[64];
//        for (int i = 0; i < (num.length); i++) {
//            num[i] = i + 1;
//            System.out.println(num[i]);
//        }
//    }


    //    STRING TO INT
    private String getResult(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    private int getIntResult(String question) {
        try {
            return Integer.parseInt(getResult(question));
        } catch (Exception e) {
            return getIntResult(question);
        }
    }


    //    function to start game
    public int startGame() {

        Personnage hero = null;

        if (warriors.isEmpty() && wizards.isEmpty()) {
            System.out.println("Vous n'avez pas créer de personnage");
        } else {
            System.out.println("Choisie ton personnage\n" + " 1-Guerrier\n" + " 2-Magicien");


            int selector2 = scanner.nextInt();
            switch (selector2) {
                case 1:
                    System.out.println("Choisir un guerrier :\n");
                    for (int i = 0; i < warriors.size(); i++) {
                        System.out.println("Guerrier : " + i + " : " + warriors.get(i));
                    }
                    System.out.println("entrer un chiffre");
                    int selectWarrior = scanner.nextInt();
                    hero = warriors.get(selectWarrior);
                    System.out.println("Vous avez choisie : " + hero);
                    break;
                case 2:
                    System.out.println("Choisir un magicien ?");
                    for (int i = 0; i < wizards.size(); i++) {
                        System.out.println("Magicien : " + i + " : " + wizards.get(i));
                    }
                    System.out.println("entrer un chiffre");
                    int selectWizard = scanner.nextInt();
                    hero = wizards.get(selectWizard);
                    System.out.println("Vous avez choisie : " + hero);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + selector2);
            }
        }

        return game.heroMovements(hero);
    }


    public void mainMenu() {

        boolean selectCondition = true;
        while (selectCondition) {
            Personnage perso;
//            Scanner scanner = new Scanner(System.in);
            int selector = getIntResult("Game Menu : \n" + " 1-Create hero\n" + " 2-Show Heroes List\n" + " 3-Start Game\n 4-End Game\n");
            switch (selector) {
                case 1:
                    Scanner clavier = new Scanner(System.in);
                    int selector1 = getIntResult("Select character : \n1 for Warrior\n2 for Wizard\n3 to see heroes\n4 to leave");
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
                            System.out.println("choix non existant...LEAVING GAME");
                    }
                    break;
                case 2:
                    System.out.println("Warriors List: \n" + warriors + "\nMages List: \n" + wizards);
                    break;
                case 3:
//                plateau();

                    System.out.println("You arrived at the end of the map. \n position: " + startGame() + "\n _____");
                    break;
                case 4:
                    selectCondition = false;
                    break;
//
            }

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
                            perso.setLifeLvl(atk);
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