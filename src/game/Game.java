package game;

import game.personnages.Personnage;
import game.plateau.setcases.HeroOutOfBoard;
import game.plateau.setcases.Plateau;
import game.personnages.Guerrier;
import game.personnages.Magicien;
import java.util.*;

public class Game {
    private Plateau plateau = new Plateau();
    private Menu menu = new Menu();
    private final ArrayList<Guerrier> warriors = new ArrayList<>();
    private final ArrayList<Magicien> wizards = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public int playGame(Personnage hero) throws HeroOutOfBoard {
        int nSides = 6;
        int position = 1;
        int roll = 0;
//        int i = 1;
        Random r = new Random();
        if (nSides >= 3) {
//            nSides= nombre de faces du dé
            System.out.println(hero.getNomPerso() + " start on the case :  " + position + "/64\n" + plateau.get(position-1) + " \n ______");
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
                if (continu) {
                        position += (Math.random() * 6) + 1;
                     if (position >= plateau.size()) {
                        throw new HeroOutOfBoard();
                    }
                }
                System.out.println(hero.getNomPerso() + " is on the case :  " + position + "/64\n" + plateau.get(position - 1) + " \n ______");
                plateau.interaction(position-1, hero);

            } while (position < plateau.size());
        } else {
            System.out.println("Error position needs to be from 3");
        }
        return position;
    }

    public void launchGame() {
        Personnage hero = null;
        if (warriors.isEmpty() && wizards.isEmpty()) {
            System.out.println("Vous n'avez pas créer de personnage");
        } else {
            System.out.println("Choisie ton personnage\n" + " 1-Guerrier\n" + " 2-Magicien");

            int selector2 = scanner.nextInt();
            switch (selector2) {
                case 1:
                    hero = menu.warriorSelect(warriors);
                    break;
                case 2:
                    hero = menu.wizardSelect(wizards);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + selector2);
            }
        }
        try {
            playGame(hero);
        } catch (HeroOutOfBoard e) {
            System.out.println("You WIN !");
        }
    }

    public void initMenu() {
        boolean selectCondition = true;
        while (selectCondition) {
            int selector = menu.getIntResult("Game Menu : \n" + " 1-Create hero\n" + " 2-Show Heroes List\n" + " 3-Start Game\n 4-End Game\n");
            switch (selector) {
                case 1:
                    Scanner clavier = new Scanner(System.in);
                    int selector1 = menu.getIntResult("Select character : \n1 for Warrior\n2 for Wizard\n3 to see heroes\n4 to leave");
                    menu.mainMenu(wizards, warriors, selector1);
                    break;
                case 2:
                    menu.displayExistingHeroes(wizards, warriors);
                    break;
                case 3:
                    launchGame();
                    break;
                case 4:
                    selectCondition = false;
                    break;
//
            }
        }
    }


}
