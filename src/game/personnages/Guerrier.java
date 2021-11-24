package game.personnages;

import game.plateau.equipement.armes.Armes;
import game.plateau.equipement.armes.massues.WoodenMace;
import game.plateau.equipement.bouclier.Bouclier;
import game.plateau.equipement.armes.massues.IronMace;
import game.plateau.equipement.bouclier.GoatShield;
import game.plateau.equipement.spells.Spell;

public class Guerrier extends Personnage {
    private GoatShield bouclier;
    private Armes arme;


    public GoatShield getBouclier() {
        return bouclier;
    }

    public void setBouclier(GoatShield bouclier) {
        this.bouclier = bouclier;
    }

    public Armes getArme() {
        return arme;
    }

    public void setArme(Armes arme) {
        this.arme = arme;
    }

    public void equipArme(Armes arme){
        this.setAtk(this.defaultAtk + arme.getAtk());
    }

    public String toString() {
        return nomPerso + ": with " + life + " life points and " + atk + " attack's points. Weapon : " + arme + " , shield:" + bouclier + "\n__\n";
    }

    public Guerrier() {
        super("Garrosh", 5, 10,5);
        this.arme = new WoodenMace();
        this.bouclier = new GoatShield();
        equipArme(arme);
    }
}




