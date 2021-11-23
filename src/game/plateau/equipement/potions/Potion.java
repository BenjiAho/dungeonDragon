package game.plateau.equipement.potions;

import game.personnages.Guerrier;
import game.personnages.Magicien;
import game.personnages.Personnage;
import game.plateau.setcases.Case;

import java.util.Scanner;

abstract public class Potion extends Case {
    private String name;
    private int life;

    protected Potion(String name, int life) {
        this.name = name;
        this.life= life;
    }

    abstract public void interaction(Personnage hero);
    abstract protected void setNewPotion(Magicien hero);
    abstract protected void displayPotion();


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
}
