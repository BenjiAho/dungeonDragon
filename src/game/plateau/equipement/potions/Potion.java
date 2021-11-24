package game.plateau.equipement.potions;

import game.personnages.Guerrier;
import game.personnages.Magicien;
import game.personnages.Personnage;
import game.plateau.setcases.Case;

import java.util.Scanner;

abstract public class Potion extends Case {
    private String name;
    private int life;

    abstract protected void displayPotion();

    protected Potion(String name, int life) {
        this.name = name;
        this.life = life;
    }

    @Override
    public String toString() {
        return "Potion: " + name + '\'' +
                ", life: " + life;
    }

    //    getters setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void interaction(Personnage hero) {
        if (hero instanceof Magicien) {
            Scanner scanner = new Scanner(System.in);

            displayPotion();
            int potion = scanner.nextInt();
            switch (potion) {
                case 1:
                    try {
                        setNewPotion((Magicien) hero);
                        System.out.println("hero new health: " + hero.getLife());
                    } catch(ExcessLife e) {
                        System.out.println(e.getMessage());
                }
                break;
                case 2:
                    break;
            }
        } else {
            System.out.println("Sorry you aren't a wizard");
        }
    }

    protected void setNewPotion(Magicien hero) throws ExcessLife {
        if(this.getLife() + hero.getLife() < hero.getMaxLife()){
            hero.setLife(this.getLife() + hero.getLife());
        }else{
            hero.setLife(hero.getMaxLife());
            throw new ExcessLife();
        }

    }
}
