package model;

import model.kamersysteem.Kamer;

import java.util.ArrayList;
import java.util.List;

public class AZC {
    private String naam;
    private Gemeente gemeente;
    private BerichtenBox berichtenBox;
    private ArrayList<Kamer> kamers;
    private ArrayList<AZCMedewerker> medewerkers;
    private ArrayList<Asielzoeker> asielzoekers;

    public AZC(String naam, Gemeente gemeente) {
        this.naam = naam;
        this.gemeente = gemeente;
        this.berichtenBox = new BerichtenBox();
        this.kamers = new ArrayList<>();
        this.medewerkers = new ArrayList<>();
        this.asielzoekers = new ArrayList<>();

    }

    public String getNaam() {
        return naam;
    }

    public int getCapaciteit() {
        int capaciteit = 0;
        for (Kamer kamer : kamers){
            capaciteit =+ kamer.getAatalSlaapplaatsen();
        }
        return capaciteit;
    }

    public int getTotaalBeschikbaarSlaapplaatsen() {
        int totaal = 0;
        for (Kamer kamer : kamers){
            totaal = totaal + kamer.getAatalBeschikbaarSlaapplaatsen();
        }
        return totaal;
    }

    public void addAsielzoeker(Asielzoeker asielzoeker) {
        asielzoekers.add(asielzoeker);

    }
    public void removeAsielzoeker(Asielzoeker asielzoeker) {
        asielzoekers.remove(asielzoeker);
    }

    public void toonAsielzoekers() {
        for (Asielzoeker asielzoeker : asielzoekers) {
            asielzoeker.toonInformatie();
        }
    }

    public void addKamer(Kamer [] kamers){
        this.kamers.addAll(List.of(kamers));
    }

    public void addKamer(Kamer kamer){
        kamers.add(kamer);
    }

    public BerichtenBox getBerichtenBox() {
        return berichtenBox;
    }

    public ArrayList<Kamer> getKamers() {
        return kamers;
    }
}
