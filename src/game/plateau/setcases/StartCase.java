package game.plateau.setcases;

import game.personnages.Personnage;
import game.plateau.setcases.Case;

public class StartCase extends Case {
    @Override
    public String toString() {
        return "Starting position";
    }

    @Override
    public void interaction(Personnage hero) {
System.out.println("test interaction");
    }
}
