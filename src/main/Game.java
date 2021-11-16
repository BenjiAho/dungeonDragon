package main;

import main.cases.*;
import main.personnages.Personnage;

import java.util.*;


public class Game {
    private final ArrayList<Case> plateau = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void getPlateau(){
        for (int i = 1; i < 64; i++) {
            plateau.add(new EmptyCase());
        }
        plateau.set(0,new StartCase());
        plateau.set(2,new Spell("perlinpinpin powder"));
        plateau.set(3,new Arme("dildo"));
        plateau.set(4,new Spell("ignite"));
        plateau.set(5,new Arme("katana"));
        plateau.set(6,new Bouclier("belt"));
        plateau.set(7,new Potion("celerity potion"));
        plateau.set(8,new Ennemi("rocco"));
        plateau.set(9,new Spell("maximus"));
        plateau.set(10,new Bouclier("trash can cover"));
        plateau.set(11,new Ennemi("pika-pas-chou"));
        plateau.set(12,new Spell("lili-putain"));
        plateau.set(13,new Arme("little spoon"));
        plateau.set(14,new Ennemi("tartare-man"));
        plateau.set(15,new Potion("rage potion"));
        plateau.set(16,new Ennemi("tartare-man"));
        plateau.set(17,new Spell("lighting"));
        plateau.set(18,new Arme("little spoon"));
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



                System.out.println(hero.getNomPerso() +" is on the case :  "+ position + "/64\n he gets "+ plateau.get(position) + " \n ______");
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
