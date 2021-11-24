package game.plateau.setcases;


import game.CharacterDead;
import game.personnages.Personnage;

abstract public class Case{

    public abstract void interaction(Personnage hero) throws CharacterDead;
}
