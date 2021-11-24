package game.personnages;

abstract public class Personnage {

    protected int maxLife;
    protected String nomPerso;
    protected int life;
    protected int atk;
    protected int defaultAtk;
    private boolean runAway;

    public boolean isRunAway() {
        return runAway;
    }

    public void setRunAway(boolean runAway) {
        this.runAway = runAway;
    }



//CONSTRUCTOR

    public Personnage(String nomPerso, int life, int maxLife, int defaultAtk) {
        this.nomPerso = nomPerso;
        this.life = life;
        this.maxLife = maxLife;
        this.defaultAtk = defaultAtk;
    }

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
    public int getMaxLife() {
        return maxLife;
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
