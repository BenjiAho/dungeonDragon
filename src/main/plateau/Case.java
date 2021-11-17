package main.plateau;


import main.personnages.Personnage;

abstract public class Case{

    public void EmptyCase(){

    }
    public abstract void interaction(Personnage hero);
}
