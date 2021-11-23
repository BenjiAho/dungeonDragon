package game.plateau.equipement.armes.massues;

import game.personnages.Guerrier;
import game.personnages.Personnage;
import game.plateau.equipement.armes.Armes;
import game.plateau.equipement.armes.swords.IcySword;
import game.plateau.equipement.armes.swords.SteelSword;

import java.util.Scanner;

public class IronMace extends Massues {

    public IronMace() {
        super("Iron");
    }


    public void interaction(){
        Armes armes = new IronMace();
    }
}
