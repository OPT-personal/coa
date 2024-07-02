package model;

import java.util.ArrayList;

public class Gemeente {
    private String naam;
    private int aantalInwoners;
    private ArrayList<AZC> AZCS;


    public Gemeente(String naam, int aantalInwoners) {
        this.naam = naam;
        this.aantalInwoners = aantalInwoners;
        AZCS = new ArrayList<>();
    }

    public void voegAZCToe(AZC azc) {
        AZCS.add(azc);
    }

    public String getNaam() {
        return naam;
    }

    public int getAantalInwoners() {
        return aantalInwoners;
    }

    public int getCapaciteit() {
        int capaciteit = 0;
        for (AZC azc : AZCS){
            capaciteit += azc.getCapaciteit();
        }
        return capaciteit;
    }

    public int getAantalBeschikbaarPlaatsen() {
        int beschikbaarPLaatsen = 0;
        for (AZC azc : AZCS){
            beschikbaarPLaatsen += azc.getTotaalBeschikbaarSlaapplaatsen();
        }
        return beschikbaarPLaatsen;
    }


    public ArrayList<AZC> getAZCS() {
        return AZCS;
    }
}
