package model.kamersysteem;

import model.AZC;
import model.Asielzoeker;

public class IndividueelKamerPlaatsing extends KamerSysteem {


    @Override
    protected Boolean kamerCheck(Kamer kamer, Asielzoeker asielzoeker) {
        return kamer.getAatalSlaapplaatsen() == 1 && kamer.isVoorVeiligLanden() == asielzoeker.getLandVanHerKomst().isVeilig();
    }

    @Override
    protected void plaatsAsielzoeker(Asielzoeker asielzoeker, Kamer kamer, AZC azc) {

    }
}
