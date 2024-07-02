package model;

import model.kamersysteem.IndividueelKamerPlaatsing;
import model.kamersysteem.KamerSysteem;

public class NonBinairAsielzoeker extends Asielzoeker{
    public NonBinairAsielzoeker(String naam, int leeftijd, String gender, Land landVanHerKomst, int id, AZC azc) {
        super(naam, leeftijd, gender, landVanHerKomst, id, azc);
    }

    @Override
    public KamerSysteem getKamerSysteem() {
        return new IndividueelKamerPlaatsing();
    }
}
