package game.plateau.potions;

import game.plateau.setcases.Case;

abstract public class Potion extends Case {
    private String name;
    private int life;

    protected Potion(String name, int life) {
        this.name = name;
        this.life= life;
    }

    @Override
    public String toString() {
        return "Potion: " + name + '\'' +
                ", life=" + life;
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
