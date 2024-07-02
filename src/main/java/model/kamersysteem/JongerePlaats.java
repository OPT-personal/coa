package model.kamersysteem;

import model.AZC;
import model.Asielzoeker;

public class JongerePlaats extends KamerSysteem {
    @Override
    protected Boolean kamerCheck(Kamer kamer, Asielzoeker asielzoeker) {
        return kamer.isVoorVeiligLanden() == asielzoeker.getLandVanHerKomst().isVeilig() && kamer.getAatalBeschikbaarSlaapplaatsen() > 0;
    }

    @Override
    protected void plaatsAsielzoeker(Asielzoeker asielzoeker, Kamer kamer, AZC azc) {

    }
}
