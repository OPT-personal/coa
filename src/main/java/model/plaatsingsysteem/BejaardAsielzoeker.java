package model.plaatsingsysteem;

import model.AZC;
import model.Asielzoeker;
import model.Land;
import model.kamersysteem.IndividueelKamerPlaatsing;
import model.kamersysteem.KamerSysteem;

public class BejaardAsielzoeker extends Asielzoeker {
    public BejaardAsielzoeker(String naam, int leeftijd, String gender, Land landVanHerKomst, int id, AZC azc) {
        super(naam, leeftijd, gender, landVanHerKomst, id, azc);
    }

    @Override
    public KamerSysteem getKamerSysteem() {
        return new IndividueelKamerPlaatsing();
    }
}
