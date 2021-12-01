package game.plateau.ennemies;

import game.CharacterDead;
import game.personnages.Personnage;
import game.plateau.setcases.Case;

import java.util.Scanner;

abstract public class Ennemi implements Case {
    private String race;
    private int life;
    private int atk;


    protected Ennemi(String race, int life, int atk) {
        this.race = race;
        this.life = life;
        this.atk = atk;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    @Override
    public void interaction(Personnage hero) throws CharacterDead {
        if (hero != null) {
            Scanner scanner = new Scanner(System.in);
            foundEnemy();
            int fightChoice = scanner.nextInt();
            switch (fightChoice) {
                case 1:
                    fight(hero);
                    break;
                case 2:
                    hero.setRunAway(true);
                    break;
            }
        }
    }

    public void foundEnemy() {
        System.out.println("there is a " + this.getRace() + "\n1: fight \n2: flee");
    }

    public void fight(Personnage hero) throws CharacterDead {
        while (this.getLife() > 0) {
            hitFromHero(hero);
            enemyIsAlive(hero);
        }
        if (hero.getLife() <= 0) {
            throw new CharacterDead();
        }
    }

    public void hitFromHero(Personnage hero) {
        this.setLife(this.getLife() - hero.getAtk());
    }

    public void hitFromEnemy(Personnage hero) {
        hero.setLife(hero.getLife() - this.getAtk());
    }

    public void enemyIsAlive(Personnage hero) {
        if (this.getLife() > 0) {
            System.out.println(this.getRace() + " still has" + this.getLife() + " hp\n");
            System.out.println(this.getRace() + " is now attacking you!");
            hitFromEnemy(hero);
            System.out.println(hero.getNomPerso() + " has " + hero.getLife() + " hp left!");
        } else {
            System.out.println(this.getRace() + " is dead!");
        }
    }


}
