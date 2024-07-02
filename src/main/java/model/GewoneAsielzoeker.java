package model;

import model.kamersysteem.KamerSysteem;
import model.kamersysteem.gewoneKamerPlaatsing;

public class GewoneAsielzoeker extends Asielzoeker{
    public GewoneAsielzoeker(String naam, int leeftijd, String gender, Land landVanHerKomst, int id, AZC azc) {
        super(naam, leeftijd, gender, landVanHerKomst, id, azc);
    }

    @Override
    public KamerSysteem getKamerSysteem() {
        return new gewoneKamerPlaatsing();
    }
}
