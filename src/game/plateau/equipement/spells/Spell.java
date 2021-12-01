package game.plateau.equipement.spells;

import game.personnages.Magicien;
import game.personnages.Personnage;
import game.plateau.setcases.Case;

abstract public class Spell implements Case {
    private String name;
    private int atk;

    protected Spell(String name, int atk) {
        this.name = name;
        this.atk = atk;
    }

    //    getters setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    abstract public void interaction(Personnage hero);

    abstract protected void setNewSpell(Magicien hero);

    abstract protected void displaySpell();

    @Override
    public String toString() {
        return "New Spell:" + name ;
    }
}