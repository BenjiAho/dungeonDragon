package main;

import java.util.*;

public class Menu {
    public static void main(String[] args) {

        System.out.println("Starting game");
        Menu data = new Menu();
        data.selectHero();
    }

    //    public void plateau() {
//        int num[] = new int[64];
//        for (int i = 0; i < (num.length); i++) {
//            num[i]=i+1;
//            System.out.println(num[i]);
//        }
//    }
    public static final int mapSize = 64;

    public static int rollDice(int number, int nSides) {
        int position = 1;
        int roll = 0;
//        int i = 1;
        Random r = new Random();
        if (nSides >= 3) {
            do {
                roll = r.nextInt(nSides) + 1;
                System.out.println("Roll is:  " + roll);
                position = position + roll;
                System.out.println("position actuelle: " + position + "/64");
                if (position > mapSize) {
                    position = mapSize;
                }
            } while (position < mapSize);
        } else {
            System.out.println("Error position needs to be from 3");
        }
        return position;
    }

    public void selectHero() {
        ArrayList<Guerrier> warriors = new ArrayList<Guerrier>();
        ArrayList<Magicien> mages = new ArrayList<Magicien>();


        boolean selectCondition = true;
        while (selectCondition) {
            Personnage perso;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Game Menu : \n" + " 1-Create hero\n" + " 2-Show Heroes List\n" + " 3-Start Game\n 4-End Game\n");
            int selector = scanner.nextInt();
            switch (selector) {
                case 1:
                    Scanner clavier = new Scanner(System.in);
                    System.out.println("Select character : \n1 for Warrior\n2 for Wizard\n3 to see heroes\n4 to leave");
                    int selector1 = clavier.nextInt();
                    switch (selector1) {
                        case 1:
                            System.out.println("Warrior selected");

                            perso = new Guerrier();

                            warriors.add((Guerrier)perso);
                            selectionPersonnage(perso, true);
                            break;
                        case 2:
                            System.out.println("Wizard selected");
                            perso = new Magicien();
                            mages.add((Magicien)perso);
                            selectionPersonnage(perso, false);
                            break;
                        case 3:
                            System.out.println(warriors);
                            System.out.println(mages);
                            break;
                        case 4:
                            System.out.println("End of game");
                            break;
                        default:
                            System.out.println("choix non existant...LEAVING GAME");
                    }
                    break;
                case 2:
                    System.out.println("Warriors List: \n" + warriors + "\nMages List: \n" + mages);
                    break;
                case 3:
//                plateau();
                    System.out.println("Position finale sur plateau: " + rollDice(1, 6));
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
        System.out.println("Enter name of the warrior: ");

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
                    ? "\nweapon: " + ((Guerrier)perso).getArme() +  "\nshield: " + ((Guerrier)perso).getBouclier()
                    : "\nspell: " + ((Magicien)perso).getSpell() +  "\npotion: " + ((Magicien)perso).getPotion()));

//                    + "\nweapon: " + ((isWarrior) ? ((Guerrier)perso).getArme() : ((Magicien)perso).getSpell())
//                    + "\nshield: " + ((isWarrior) ? ((Guerrier)perso).getBouclier() : ((Magicien)perso).getPotion()));

            System.out.println("Change hero attributes: \nA for life points\nB for atk points\nC for weapon" + "\nD for shield" + "\nX exit menu" + "\n___________________________");
            String warriorChoices = sc.next();


            switch (warriorChoices.toUpperCase()) {

                case "A":
                    boolean validLife = false;
                    do{
                        System.out.println("enter life between 5 and 10");
                        int life = sc.nextInt();
                        if(life >= 5 && life <= 10){
                            perso.setLifeLvl(life);
                            validLife = true;
                        }else{
                            System.out.println("enter valid value *");
                        }
                    }while(!validLife);
                    System.out.println("___________________________"
                            + "\nHero's name: " + perso.nomPerso +
                            "\nLife points: " + perso.life
                            + "\natk points: " + perso.atk
                            + ((isWarrior)
                            ? "\nweapon: " + ((Guerrier)perso).getArme() +  "\nshield: " + ((Guerrier)perso).getBouclier()
                            : "\nspell: " + ((Magicien)perso).getSpell() +  "\npotion: " + ((Magicien)perso).getPotion())
                            + "\n___________________________");
                    break;
                case "B":
                    boolean validAtk = false;
                    do{
                        System.out.println("enter atk between 5 and 10");
                        int atk = sc.nextInt();
                        if(atk >= 5 && atk <= 10){
                            perso.setLifeLvl(atk);
                            validAtk = true;
                        }else{
                            System.out.println("enter valid value *");
                        }
                    }
                    while (!validAtk);
                    System.out.println("___________________________"
                            + "\nHero's name: " + perso.nomPerso +
                            "\nLife points: " + perso.life
                            + "\natk points: " + perso.atk
                            + ((isWarrior)
                            ? "\nweapon: " + ((Guerrier)perso).getArme() +  "\nshield: " + ((Guerrier)perso).getBouclier()
                            : "\nspell: " + ((Magicien)perso).getSpell() +  "\npotion: " + ((Magicien)perso).getPotion())
                            + "\n___________________________");
                    break;
                case "C":
                    System.out.println("set weapon: ");
                    String armes = sc.next();
                    System.out.println("___________________________"
                            + "\nHero's name: " + perso.nomPerso +
                            "\nLife points: " + perso.life
                            + "\natk points: " + perso.atk
                            + ((isWarrior)
                            ? "\nweapon: " + ((Guerrier)perso).getArme() +  "\nshield: " + ((Guerrier)perso).getBouclier()
                            : "\nspell: " + ((Magicien)perso).getSpell() +  "\npotion: " + ((Magicien)perso).getPotion())
                            + "\n___________________________");
                    ((Guerrier)perso).setArme(new Arme(armes));
                    break;
                case "D":
                    System.out.println("set Shield: ");
                    String bouclier = sc.next();
                    ((Guerrier)perso).setBouclier(bouclier);
                    System.out.println("___________________________"
                            + "\nHero's name: " + perso.nomPerso
                            + "\nLife points: " + perso.life
                            + "\natk points: " + perso.atk
                            + "\nweapon: " + ((Guerrier)perso).getArme()
                            + "\nshield: " + ((Guerrier)perso).getBouclier()
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
