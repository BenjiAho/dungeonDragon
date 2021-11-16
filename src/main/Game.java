package main;

import main.cases.Arme;
import main.cases.Case;
import main.personnages.Personnage;

import java.util.*;


public class Game {
    private final ArrayList<Case> plateau = new ArrayList<>();
    private int positionHero = 1;
    private final Scanner scanner = new Scanner(System.in);

    public void getPlateau(){
        for (int i = 0; i < 64; i++) {
            plateau.add(null);
        }
        plateau.set(1,new Arme("truc"));
        System.out.println(plateau);
        System.out.println("Taille du plateau :" + plateau.size());
    }
    public int heroMovements(Personnage hero) {
        int nSides = 6;
        int position = 1;
        int roll = 0;

//        int i = 1;
        Random r = new Random();
        getPlateau();
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



                System.out.println(hero.getNomPerso() + position + "/64 \n ______");
                if (continu) {
                    position += (Math.random() * 6) + 1;
                }

                if (position > plateau.size()) {
                    position = plateau.size();
                }
            } while (position < plateau.size());
        } else {
            System.out.println("Error position needs to be from 3");
        }
        return position;
    }
}
