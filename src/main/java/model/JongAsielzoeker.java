package model;

import model.kamersysteem.JongerePlaats;
import model.kamersysteem.KamerSysteem;

public class JongAsielzoeker extends Asielzoeker{
    public JongAsielzoeker(String naam, int leeftijd, String gender, Land landVanHerKomst, int id, AZC azc) {
        super(naam, leeftijd, gender, landVanHerKomst, id, azc);
    }

    @Override
    public KamerSysteem getKamerSysteem() {
        return new JongerePlaats();
    }
}
