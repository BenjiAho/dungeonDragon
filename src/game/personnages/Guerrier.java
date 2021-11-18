package game.personnages;

import game.plateau.armes.Armes;
import game.plateau.bouclier.Bouclier;
import game.plateau.armes.massues.IronMace;

public class Guerrier extends Personnage {


    public Bouclier getBouclier() {
        return bouclier;
    }
    public void setBouclier(Bouclier bouclier) {
        this.bouclier = bouclier;
    }


    public Armes getArme() {
        return arme;
    }
    public void setArme(Armes arme) {
        this.arme = arme;
    }

    //3constructeurs sans paramètres, avec nom et avec nom/image/niveau de vie/force d'attaque
    private Bouclier bouclier;
    private Armes arme;


    public String toString() {
        return nomPerso + ": with " + life + " life points and " + atk + " attack's points. Weapon : " + arme + " , shield:" + bouclier + "\n__\n";
    }

    public Guerrier(String nomPerso, int life, int atk, String bouclier) {
        this.nomPerso = nomPerso;
        this.life = life;
        this.atk = atk;
        this.arme = new IronMace();
        this.bouclier = new Bouclier(bouclier);
    }


    public Guerrier() {
        this("Garrosh", 10, 10, "Bouclier en tête de bouc! ");
    }
}




