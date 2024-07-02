package model.kamersysteem;

import model.Asielzoeker;

import java.util.ArrayList;

public abstract class Kamer {
    private int aatalSlaapplaatsen;
    private ArrayList<Asielzoeker> asielzoekers;
    private String geslacht;
    private boolean isVoorVeiligLanden;



    public Kamer(int aatalSlaapplaatsen) {
        this.aatalSlaapplaatsen = aatalSlaapplaatsen;
        this.asielzoekers = new ArrayList<>();
    }

    public int getAatalSlaapplaatsen() {
        return aatalSlaapplaatsen;
    }

    public int getAatalBeschikbaarSlaapplaatsen() {
        return aatalSlaapplaatsen - asielzoekers.size();
    }

    public String getGeslacht() {
        return geslacht;
    }

    public boolean isVoorVeiligLanden() {
        return isVoorVeiligLanden;
    }
}
