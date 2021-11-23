package game.personnages;

abstract public class Personnage {

    protected String nomPerso;
    protected int life;
    protected int atk;

//GETTERS
    public String getNomPerso() {
        return nomPerso;
    }
    public int getLife() {
        return life;
    }
    public int getAtk() {
        return atk;
    }

//    SETTERS
    public void setNomPerso(String nomPerso) {
        this.nomPerso = nomPerso;
    }
    public void setLife(int life) {
        this.life = life;
    }
    public void setAtk(int atk) {
        this.atk = atk;
    }

}
