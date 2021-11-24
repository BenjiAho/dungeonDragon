package game.plateau.equipement.potions;

public class ExcessLife extends Exception {
    public ExcessLife() {
        super("your health is full, actual lifePoints : 6hp");
    }
}
