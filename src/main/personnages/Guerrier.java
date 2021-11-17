package main.personnages;

import main.plateau.armes.Arme;
import main.plateau.Bouclier;
import main.plateau.armes.massues.IronMace;

public class Guerrier extends Personnage {


    public Bouclier getBouclier() {
        return bouclier;
    }
    public void setBouclier(Bouclier bouclier) {
        this.bouclier = bouclier;
    }


    public Arme getArme() {
        return arme;
    }
    public void setArme(Arme arme) {
        this.arme = arme;
    }

    //3constructeurs sans paramètres, avec nom et avec nom/image/niveau de vie/force d'attaque
    private Bouclier bouclier;
    private Arme arme;


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




