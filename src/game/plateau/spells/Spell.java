package game.plateau.spells;

import game.plateau.setcases.Case;

abstract public class Spell extends Case {
    private String name;
    private int atk;

    protected Spell(String name,int atk) {
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



    @Override
    public String toString() {
        return "Spell:"+ name + " , atk : " + atk;
    }
}