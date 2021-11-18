package game.plateau.potions;

import game.personnages.Personnage;

public class BasicPotion extends Potion {

    public BasicPotion(){
        super("Small health potion", 2);
    }
    @Override
    public void interaction(Personnage hero) {

    }
}
