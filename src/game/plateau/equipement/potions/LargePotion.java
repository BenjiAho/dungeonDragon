package game.plateau.equipement.potions;

import game.personnages.Magicien;
import game.personnages.Personnage;

import java.util.Scanner;

public class LargePotion extends Potion {

    public LargePotion(){
        super("Large health potion", 5);
    }


    @Override
    public void interaction(Personnage hero) {
        if (hero instanceof Magicien) {
            Scanner scanner = new Scanner(System.in);

            displayPotion();
            int potion = scanner.nextInt();
            switch (potion) {
                case 1:
                    setNewPotion((Magicien) hero);
                    System.out.println("hero new health: " + hero.getLife());
                    break;
                case 2:
                    break;
            }
        } else {
            System.out.println("Sorry you aren't a wizard");
        }
    }


    protected void displayPotion() {
        System.out.println("Vous avez trouver " + this.getName() + this.getLife() + "!\n" + "L'equiper?\n" + " 1-Oui\n" + " 2-Non");
    }

    protected void setNewPotion(Magicien hero) {
        hero.setLife(this.getLife() + hero.getLife());
    }

}
