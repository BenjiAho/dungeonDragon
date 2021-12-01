package game.plateau.setcases;


import game.CharacterDead;
import game.personnages.Personnage;

public interface Case{

        void interaction(Personnage hero) throws CharacterDead;
}
