package main.plateau;

import main.plateau.armes.massues.CrystalMace;
import main.plateau.armes.massues.IronMace;
import main.plateau.armes.massues.StoneMace;
import main.plateau.armes.swords.CrystalSword;
import main.plateau.armes.swords.IcySword;
import main.plateau.armes.swords.SteelSword;
import main.plateau.ennemies.dragons.ElderDragon;
import main.plateau.ennemies.dragons.FireDragon;
import main.plateau.ennemies.dragons.IceDragon;
import main.plateau.ennemies.dragons.LightningDragon;
import main.plateau.ennemies.goblins.Bogey;
import main.plateau.ennemies.goblins.Hobgoblin;
import main.plateau.ennemies.goblins.Knocker;
import main.plateau.ennemies.sorciers.Harry;
import main.plateau.ennemies.sorciers.Merlin;
import main.plateau.ennemies.sorciers.Saroumane;
import main.plateau.potions.BasicPotion;
import main.plateau.potions.LargePotion;
import main.plateau.spells.FireBall;
import main.plateau.spells.Lightning;


import java.util.ArrayList;

public class Plateau {
    private final ArrayList<Case> plateau = new ArrayList<>();

    public int size() {
        return plateau.size();
    }

    public String get(int index) {
        return plateau.get(index).toString();
    }

    public Plateau() {
        initPlateau();
        setCases();
        printCases();
    }

    private void printCases() {
        System.out.println(plateau);
        System.out.println("Taille du plateau :" + plateau.size());
    }

    private void setCases() {
        plateau.set(0,new StartCase());
        SetMaceCases();
        setLightningCases();
        SetGoblinCases();
        SetPotionCases();
        SetSorcererCases();
        SetFireBallCases();
        SetSwordCases();
        SetDragonCases();
    }

    private void SetDragonCases() {
        plateau.set(45,new IceDragon());
        plateau.set(52,new LightningDragon());
        plateau.set(56,new FireDragon());
        plateau.set(62,new ElderDragon());
    }

    private void SetSwordCases() {
        plateau.set(19,new SteelSword());
        plateau.set(26,new IcySword());
        plateau.set(53,new CrystalSword());
    }

    private void SetFireBallCases() {
        plateau.set(48,new FireBall());
        plateau.set(49,new FireBall());
    }

    private void SetSorcererCases() {
        plateau.set(10,new Harry());
        plateau.set(20,new Harry());
        plateau.set(25,new Merlin());
        plateau.set(32,new Merlin());
        plateau.set(35,new Merlin());
        plateau.set(36,new Saroumane());
        plateau.set(37,new Saroumane());
        plateau.set(40,new Saroumane());
        plateau.set(44,new Saroumane());
        plateau.set(47,new Saroumane());
    }

    private void SetPotionCases() {
        plateau.set(7,new BasicPotion());
        plateau.set(13,new BasicPotion());
        plateau.set(28,new LargePotion());
        plateau.set(31,new BasicPotion());
        plateau.set(33,new BasicPotion());
        plateau.set(39,new BasicPotion());
        plateau.set(41,new LargePotion());
        plateau.set(43,new BasicPotion());
    }

    private void SetGoblinCases() {
        plateau.set(3,new Bogey());
        plateau.set(6,new Bogey());
        plateau.set(9,new Bogey());
        plateau.set(12,new Bogey());
        plateau.set(15,new Knocker());
        plateau.set(18,new Knocker());
        plateau.set(21,new Knocker());
        plateau.set(24,new Knocker());
        plateau.set(27,new Hobgoblin());
        plateau.set(30,new Hobgoblin());
    }

    private void SetMaceCases() {
        plateau.set(2,new StoneMace());
        plateau.set(5,new StoneMace());
        plateau.set(11,new StoneMace());
        plateau.set(22,new IronMace());
        plateau.set(38,new CrystalMace());
    }

    private void setLightningCases() {
        plateau.set(1,new Lightning());
        plateau.set(4,new Lightning());
        plateau.set(8,new Lightning());
        plateau.set(17,new Lightning());
        plateau.set(23,new Lightning());
    }

    private void initPlateau() {
        for (int i = 0; i < 64; i++) {
            plateau.add(new EmptyCase());
        }
    }
}
