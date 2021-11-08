package main;

import java.util.*;

public class Menu {
    public static void main(String[] args) {

        System.out.println("Starting game");
        Menu data = new Menu();
        data.selectHero();
    }

    public void selectHero() {


//        Scanner scanner = new Scanner(System.in);

//        System.out.println("Create your character : \n1 for Warrior\n2 for Wizard\n3 to leave");

//        int choice = scanner.nextInt();
        ArrayList<Guerrier> warriors = new ArrayList<Guerrier>();
        ArrayList<Magicien> mages = new ArrayList<Magicien>();
        boolean selectCondition = true;
        while (selectCondition) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Créer un personnage? : \n" + " 1-Yes\n" + " 2-No\n"+ " 3-Show Heroes List\n");
            int selector = scanner.nextInt();
            switch (selector) {
                case 1:
                    Scanner clavier = new Scanner(System.in);
                    System.out.println("Select character : \n1 for Warrior\n2 for Wizard\n3 to see heroes\n4 to leave");
                    int selector1 = clavier.nextInt();
                    switch (selector1) {
                        case 1:
                            System.out.println("Warrior selected");

                            Guerrier warrior = new Guerrier();
                            warrior.selectionWarrior();
                            warriors.add(warrior);

                            break;
                        case 2:
                            System.out.println("Wizard selected");
                            Magicien wizard = new Magicien();
                            wizard.selectionWizard();
                            mages.add(wizard);

                            break;
                        case 3:
                            System.out.println(warriors);
                            System.out.println(mages);
                            break;
                        case 4:
                            System.out.println("End of game");
                            break;
                        default:
                            System.out.println("choix non existant...LEAVING GAME");
                    }
                    break;
                case 2:
                    selectCondition = false;
                    break;
                case 3:
                    System.out.println("Warriors List: \n"+warriors+"\nMages List: \n"+mages);
//                    System.out.println("Mages"+mages);
                    break;
            }

        }
    }
}
