package model.plaatsingsysteem;

import model.*;
import utils.IDataSeeder;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class PlaatsingSysteem implements IPublisher {
    private ArrayList<IObserver> observers;
    private IDataSeeder dataSeeder;

    public PlaatsingSysteem(IDataSeeder dataSeeder) {
        observers = new ArrayList<>();
        this.dataSeeder = dataSeeder;
    }

    @Override
    public void registerObserver(IObserver o) {
        observers.add(o);

    }

    @Override
    public void removeObserver(IObserver o) {
        observers.remove(o);

    }

    protected ArrayList<IObserver> getObservers() {
        return observers;
    }

    public void plaats(Asielzoeker asielzoeker){
        Gemeente bestGemeente = aboluutGemeente();
        if (bestGemeente == null){
            bestGemeente = bestRelatiefGemeente();
        }
        AZC azc = kiesAZC(bestGemeente);
        plaatsAsielzoker(azc,asielzoeker);

    }

    protected Gemeente aboluutGemeente(){
        int bestPlaats = 0;
        Gemeente bestAbsoluutGeemente = null;
        Gemeente [] gemeentes = dataSeeder.getAllGemeentes();
        for (Gemeente gemeente : gemeentes){
            int beschikplaatsen = gemeente.getAantalBeschikbaarPlaatsen();
            if (beschikplaatsen > bestPlaats){
                bestPlaats = beschikplaatsen;
                bestAbsoluutGeemente = gemeente;
            }
        }
        return bestAbsoluutGeemente;
    }

    protected Gemeente bestRelatiefGemeente(){
        Gemeente bestAbsoluutGeemente = null;
        double relatief = 0.0;
        for (Gemeente gemeente : dataSeeder.getAllGemeentes()){
            double berekendPercentage = ((double) gemeente.getAantalInwoners() / gemeente.getCapaciteit());
            if (relatief > berekendPercentage){
                relatief = berekendPercentage;
                bestAbsoluutGeemente = gemeente;
            }
        }
        return bestAbsoluutGeemente;
    }

    protected AZC kiesAZC(Gemeente gemeente){

        AZC gekozenAZC = null;
        if (gemeente.getAZCS().size()> 1){
            System.out.println("Kies een azc: ");
            int teller = 1;
            for (AZC azc : gemeente.getAZCS()){
                System.out.println(teller + "." + azc.getNaam());
                teller++;
            }
            Scanner scanner = new Scanner(System.in);
            int kies = scanner.nextInt();
            gekozenAZC = gemeente.getAZCS().get(kies -1);
        }
        else if (gemeente.getAZCS().size() == 1){
            gekozenAZC = gemeente.getAZCS().get(0);
        }
        else {
            System.out.println("Deze gemeente heeft geen azc");
        }
        return gekozenAZC;
    }

    public abstract void plaatsAsielzoker(AZC azc, Asielzoeker asielzoeker);





}