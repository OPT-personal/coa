package menu;

import model.Bericht;
import model.kamersysteem.KamerSysteem;

public class ActieKamerPlaatsing implements IActie{
    @Override
    public void voerActieUit() {
        Bericht bericht = null;

        KamerSysteem kamerSysteem = bericht.getAsielzoeker().getKamerSysteem();
    }
}
