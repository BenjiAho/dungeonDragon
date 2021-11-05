package main;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        System.out.println("Starting game");
        Menu data = new Menu();
        data.selectHero();



    }

    public void selectHero() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Create your character : \n1 for Warrior\n2 for Wizard\n3 to leave");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Warrior selected");
                Guerrier warrior = new Guerrier();
                warrior.selectionWarrior();
                break;
            case 2:
                System.out.println("Wizard selected");
                Magicien wizard = new Magicien();
                wizard.selectionWizard();
                break;
            case 3:
                System.out.println("End of game");
                break;
            default:
                System.out.println("choix non existant...LEAVING GAME");
        }
    }
}
