package model.kamersysteem;

import model.AZC;
import model.Asielzoeker;

import java.util.ArrayList;

public class gewoneKamerPlaatsing extends KamerSysteem {


    @Override
    protected Boolean kamerCheck(Kamer kamer, Asielzoeker asielzoeker) {
        return kamer.isVoorVeiligLanden() == asielzoeker.getLandVanHerKomst().isVeilig() && kamer.getGeslacht().equals(asielzoeker.getGender()) && kamer.getAatalBeschikbaarSlaapplaatsen() > 0;
    }

    @Override
    protected void plaatsAsielzoeker(Asielzoeker asielzoeker, Kamer kamer, AZC azc) {

    }

}
