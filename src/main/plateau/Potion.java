package main.plateau;

import main.personnages.Personnage;

public class Potion extends Case{
    private Object potion;


    public Object getPotion() {
        return potion;
    }

    public void setPotion(Object potion) {
        this.potion = potion;
    }

    @Override
    public void interaction(Personnage hero) {

    }
}
