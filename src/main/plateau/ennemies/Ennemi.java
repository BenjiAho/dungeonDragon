package main.plateau.ennemies;

import main.personnages.Personnage;
import main.plateau.Case;

abstract public class Ennemi extends Case {
    private String race;
    private int life;
    private int atk;

    protected Ennemi(String race,int life,int atk){
        this.race = race;
        this.life = life;
        this.atk = atk;
    }
//    public String getType() {
//        return type;
//    }
//    public void setType(String type) {
//        this.type = type;
//    }

    @Override
    public void interaction(Personnage hero) {

    }
}
