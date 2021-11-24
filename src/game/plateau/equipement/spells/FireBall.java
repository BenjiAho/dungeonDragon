package game.plateau.equipement.spells;

import game.personnages.Magicien;
import game.personnages.Personnage;

import java.util.Scanner;

public class FireBall extends Spell{

    public FireBall(){
        super("FireBall", 7);
    }


    @Override
    public void interaction(Personnage hero) {
        if (hero instanceof Magicien) {
            Scanner scanner = new Scanner(System.in);

            displaySpell();
            int potion = scanner.nextInt();
            switch (potion) {
                case 1:
                    setNewSpell((Magicien) hero);
                    ((Magicien) hero).equipSpell(((Magicien) hero).getSpell());
                    System.out.println(hero.getNomPerso()+ " get a " +((Magicien) hero).getSpell() +", Total ATK: " + hero.getAtk());
                    break;
                case 2:
                    break;
            }
        } else {
            System.out.println("Sorry you aren't a wizard");
        }
    }


    protected void displaySpell() {
        System.out.println("Vous avez trouver " + this.getName() + " with an ATK of " + this.getAtk()+ "!\n" + "L'equiper?\n" + " 1-Oui\n" + " 2-Non");
    }

    protected void setNewSpell(Magicien hero) {
        hero.setSpell(new FireBall());
    }

}
