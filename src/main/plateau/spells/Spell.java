package main.plateau.spells;

import main.personnages.Personnage;
import main.plateau.Case;

abstract public class Spell extends Case {
    private Object spell;

    public Object getSpell() {
        return spell;
    }

    public void setSpell(Object spell) {
        this.spell = spell;
    }

    @Override
    public void interaction(Personnage hero) {

    }
}