package main;

import java.util.*;

public class Menu {
    public static void main(String[] args) {

        System.out.println("Starting game");
        Menu data = new Menu();
        data.mainMenu();
    }

    //    public void plateau() {
//        int num[] = new int[64];
//        for (int i = 0; i < (num.length); i++) {
//            num[i]=i+1;
//            System.out.println(num[i]);
//        }
//    }
    private final Scanner scanner = new Scanner(System.in);
    private final ArrayList<Guerrier> warriors = new ArrayList<>();
    private final ArrayList<Magicien> wizards = new ArrayList<>();
    public final int mapSize = 64;


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
        int nSides = 6;
        int position = 1;
        int roll = 0;

//        int i = 1;
        Random r = new Random();
        if (nSides >= 3) {
//            nSides= nombre de faces du dé
            do {
                boolean continu = false;

                System.out.println("Roll?\n  1-Yes\n  2-No");
                int response = scanner.nextInt();
                switch (response) {
                    case 1:
                        continu = true;
                        break;
                    case 2:
                        System.exit(0);
                        break;
                }

                roll = r.nextInt(nSides) + 1;
                System.out.println("Roll is:  " + roll);
                position = position + roll;
                System.out.println( hero.getNomPerso() + position + "/64 \n ______");
                if (continu) {
                    position += (Math.random() * 6) + 1;
                }

                if (position > mapSize) {
                    position = mapSize;
                }
            } while (position < mapSize);
        } else {
            System.out.println("Error position needs to be from 3");
        }
        return position;
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
                    + "\nHero's name: " + perso.nomPerso +
                    "\nLife points: " + perso.life
                    + "\natk points: " + perso.atk
                    + ((isWarrior)
                    ? "\nweapon: " + ((Guerrier) perso).getArme() + "\nshield: " + ((Guerrier) perso).getBouclier()
                    : "\nspell: " + ((Magicien) perso).getSpell() + "\npotion: " + ((Magicien) perso).getPotion()));


            int heroChoices = getIntResult("Change hero attributes: \n1 for life points\n2 for atk points" + ((isWarrior) ? "\n3 for weapon" + "\n4 for shield" : "\n5 for spell" + "\n6 for potion") + "\n7 exit menu" + "\n___________________________");

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
                            + "\nHero's name: " + perso.nomPerso +
                            "\nLife points: " + perso.life
                            + "\natk points: " + perso.atk
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
                            + "\nHero's name: " + perso.nomPerso +
                            "\nLife points: " + perso.life
                            + "\natk points: " + perso.atk
                            + ((isWarrior)
                            ? "\nweapon: " + ((Guerrier) perso).getArme() + "\nshield: " + ((Guerrier) perso).getBouclier()
                            : "\nspell: " + ((Magicien) perso).getSpell() + "\npotion: " + ((Magicien) perso).getPotion())
                            + "\n___________________________");
                    break;
                case 3:
                    System.out.println((isWarrior)
                            ? "Set weapon: "
                            : "Set spell: ");


                    if (isWarrior) {
                        String armes = sc.next();
                        ((Guerrier) perso).setArme(new Arme(armes));
                    } else {
                        String spells = sc.next();
                        ((Magicien) perso).setSpell(new Spell(spells));
                    }

                    System.out.println("___________________________"
                            + "\nHero's name: " + perso.nomPerso +
                            "\nLife points: " + perso.life
                            + "\natk points: " + perso.atk
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
                        String bouclier = sc.next();
                        ((Guerrier) perso).setBouclier(bouclier);
                    } else {
                        String potion = sc.next();
                        ((Magicien) perso).setPotion(potion);
                    }
                    System.out.println("___________________________"
                            + "\nHero's name: " + perso.nomPerso
                            + "\nLife points: " + perso.life
                            + "\natk points: " + perso.atk
                            + ((isWarrior)
                            ? "\nweapon: " + ((Guerrier) perso).getArme() + "\nshield: " + ((Guerrier) perso).getBouclier()
                            : "\nspell: " + ((Magicien) perso).getSpell() + "\npotion: " + ((Magicien) perso).getPotion())
                            + "\n___________________________");
                    break;
                case 5:
                    System.out.println("End of game");
                    break;
                case 6:
                    System.out.println("Back to menu");
                    condition = false;
                    break;
            }
        }
    }


}
