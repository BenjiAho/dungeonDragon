package main.personnages;

import main.plateau.potions.BasicPotion;
import main.plateau.spells.Lightning;
import main.plateau.spells.Spell;

public class Magicien extends Personnage {
    //3constructeurs sans paramètres, avec nom et avec nom/image/niveau de vie/force d'attaque

    private Spell spell;
    private BasicPotion potion;

    public String toString() {
        return nomPerso + ": with " + life + " " + "life points and" + " " + atk + " atk points. Spell : " + " " + spell + " " + "with " + potion + "\n__\n";
    }

    public Magicien(String nomPerso, int life, int atk, String potion) {
        this.nomPerso = nomPerso;
        this.life = life;
        this.atk = atk;
        this.spell = new Lightning();
        this.potion = new BasicPotion();
    }


    public Magicien() {
        this("GLANDALF", 6, 15, "Viagra Potion");
    }



    public Spell getSpell() {
        return spell;
    }
    public void setSpell(Spell spell) {
        this.spell = spell;
    }

    public BasicPotion getPotion() {
        return potion;
    }
    public void setPotion(BasicPotion potion) {
        this.potion = potion;
    }

}




