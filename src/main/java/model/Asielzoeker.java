package model;

import menu.Menu;
import model.kamersysteem.KamerSysteem;
import utils.DataSeeder;

public abstract class Asielzoeker extends Gebruiker {

    private final int leeftijd;
    private final String gender;
    private final Land landVanHerKomst;
    private final Dossier dossier;
    private Gezin gezin;
    private AZC azc;

    public Asielzoeker(String naam, int leeftijd, String gender, Land landVanHerKomst,int id,AZC azc) {
        super(naam,id);
        this.leeftijd = leeftijd;
        this.gender = gender;
        this.landVanHerKomst = landVanHerKomst;
        this.dossier = new Dossier();
        this.gezin = null;
        this.azc = azc;
    }

    public void setAzc(AZC azc) {
        this.azc = azc;
    }

    public Gezin getGezin() {
        return gezin;
    }

    public void setGezin(Gezin gezin) {
        this.gezin = gezin;
    }

    public AZC getAzc() {
        return azc;
    }

    public String getGender() {
        return gender;
    }

    public Land getLandVanHerKomst() {
        return landVanHerKomst;
    }

    @Override
    public Menu getMenu() {
        return DataSeeder.getInstance().getAsielzoekerMenu();
    }

    public void toonInformatie() {
        System.out.println("Naam: " + super.getNaam() + " | ID: " + super.getID());
    }

    public abstract KamerSysteem getKamerSysteem();


}
