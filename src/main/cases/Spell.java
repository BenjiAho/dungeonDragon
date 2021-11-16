package main.cases;

public class Spell extends Case {
    private String spell;

    public Spell(String spell) {
        this.spell = spell;
    }

    public String toString() {
        return spell;
    }
}