package model;

import menu.Menu;
import utils.DataSeeder;

public abstract class Gebruiker {
    private int ID;
    private final String naam;

    public Gebruiker(String naam,int id) {
        this.naam = naam;
        this.ID = id;
    }

    public String getNaam() {
        return naam;
    }

    public int getID() {
        return ID;
    }

    public abstract Menu getMenu();


}
