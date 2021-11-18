package game.plateau.potions;

import game.personnages.Personnage;

public class LargePotion extends Potion {

    public LargePotion(){
        super("Large health potion", 5);
    }


    @Override
    public void interaction(Personnage hero) {
        System.out.println("hero picks" + super.getName());
    }
}
