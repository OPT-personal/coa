package model.kamersysteem;

import model.AZC;
import model.Asielzoeker;
import model.Bericht;

import java.util.ArrayList;

public abstract class KamerSysteem {

    public final void startProcces(Asielzoeker asielzoeker, Bericht bericht) {
        AZC bestemmingAZC = bericht.getBestemmingAZC();
        AZC herkomstAZC = bericht.getHerkomstAZC();


            Kamer kamer = vindGoedKamer(asielzoeker, bestemmingAZC);
            if (kamer != null) {
                plaatsAsielzoeker(asielzoeker, kamer, bestemmingAZC);
                updateAZC(asielzoeker, herkomstAZC,bestemmingAZC);
                toonSuccesKamerPlaatsing(asielzoeker, kamer, bestemmingAZC);
                verwijderBericht(bestemmingAZC,bericht);
            } else {
                toonGefaaldKamerPlaatsing(asielzoeker, bestemmingAZC);
            }
    }

    protected abstract Boolean kamerCheck(Kamer kamer, Asielzoeker asielzoeker);
    protected abstract void plaatsAsielzoeker(Asielzoeker asielzoeker, Kamer kamer, AZC azc);

    private void verwijderBericht(AZC azc, Bericht bericht) {
        azc.getBerichtenBox().removeBericht(bericht);
    }

    protected Kamer vindGoedKamer(Asielzoeker asielzoeker, AZC azc){
        ArrayList<Kamer> kamers = azc.getKamers();
        for (Kamer kamer : kamers){
            if (kamerCheck(kamer,asielzoeker)){
                return kamer;
            }
        }
        return null;
    }

    protected void updateAZC(Asielzoeker asielzoeker, AZC herkomst,AZC bestemming){
        herkomst.removeAsielzoeker(asielzoeker);
        bestemming.addAsielzoeker(asielzoeker);
    }


    protected void toonSuccesKamerPlaatsing(Asielzoeker asielzoeker, Kamer kamer, AZC azc) {
        System.out.println("Asielzoeker " + asielzoeker.getNaam() + " is geplaatst in kamer");
    }

    protected void toonGefaaldKamerPlaatsing(Asielzoeker asielzoeker, AZC azc) {
        System.out.println("Geen geschikte kamer gevonden voor " + asielzoeker.getNaam());
    }

}
