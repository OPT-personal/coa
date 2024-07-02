package model.plaatsingsysteem;

import model.AZC;
import model.Asielzoeker;
import model.IObserver;
import utils.IDataSeeder;

public class GezinPlaatsing extends PlaatsingSysteem  {

    public GezinPlaatsing(IDataSeeder dataSeeder) {
        super(dataSeeder);
    }

    @Override
    public void plaatsAsielzoker(AZC azc, Asielzoeker asielzoeker) {
        AZC herkomst = asielzoeker.getAzc();
        for (Asielzoeker asielzoeker1 : asielzoeker.getGezin().getLeden()){
            asielzoeker1.getAzc().removeAsielzoeker(asielzoeker);
            asielzoeker1.setAzc(azc);
            azc.addAsielzoeker(asielzoeker1);
        }
        notifyObservers(herkomst,azc,asielzoeker);
    }

    @Override
    public void notifyObservers(AZC bestemming,AZC herkomst,Asielzoeker asielzoeker) {
        for (IObserver observer : getObservers()){
            observer.update(bestemming,herkomst,asielzoeker,"Gezin plaatsing");
        }
    }
}
