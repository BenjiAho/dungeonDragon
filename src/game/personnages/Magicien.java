package game.personnages;

import game.plateau.equipement.potions.BasicPotion;
import game.plateau.equipement.spells.Lightning;
import game.plateau.equipement.spells.Spell;

public class Magicien extends Personnage {
    //3constructeurs sans paramètres, avec nom et avec nom/image/niveau de vie/force d'attaque

    private Spell spell;
    private BasicPotion potion;



    public String toString() {
        return nomPerso + ": with " + life + " " + "life points and" + " " + atk + " atk points. Spell : " + " " + spell + " " + "with " + potion + "\n__\n";
    }

    public void equipSpell(Spell spell){
        this.setAtk(this.defaultAtk + spell.getAtk());
    }

    public Magicien() {
        super("GLANDALF", 3, 6,10);
        this.spell = new Lightning();
        this.potion = new BasicPotion();
        equipSpell(spell);
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




