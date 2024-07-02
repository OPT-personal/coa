package menu;

import model.*;
import model.plaatsingsysteem.IndividueelPlaatsing;
import model.plaatsingsysteem.PlaatsingSysteem;
import utils.DataSeeder;


public class ActiePlaatsAsielzoeker implements IActie {
    @Override
    public void voerActieUit() {
        DataSeeder dataSeeder = DataSeeder.getInstance();
        PlaatsingSysteem plaatsingSysteem = new IndividueelPlaatsing(DataSeeder.getInstance());
        for (Gemeente gemeente : dataSeeder.getAllGemeentes()){
            for (AZC azc : gemeente.getAZCS()){
                plaatsingSysteem.registerObserver(azc.getBerichtenBox());
            }
        }
        plaatsingSysteem.plaats((Asielzoeker) dataSeeder.getGebruiker(3000));




    }
}
