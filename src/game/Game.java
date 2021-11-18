package game;

import game.personnages.Personnage;
import game.plateau.setcases.HeroOutOfBoard;
import game.plateau.setcases.Plateau;

import java.util.*;


public class Game {

    private final Scanner scanner = new Scanner(System.in);

    public void getPlateau() {
    }


    public int playGame(Personnage hero) throws HeroOutOfBoard {
        int nSides = 6;
        int position = 1;
        int roll = 0;
        int index = 0;
//        int i = 1;
        Random r = new Random();
        Plateau plateau = new Plateau();
        if (nSides >= 3) {
//            nSides= nombre de faces du dé
            System.out.println(hero.getNomPerso() + " start on the case :  " + position + "/64\n" + plateau.get(index) + " \n ______");
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

            } while (position < plateau.size());
        } else {
            System.out.println("Error position needs to be from 3");
        }
        return position;
    }
}