package model.plaatsingsysteem;

import model.AZC;
import model.Asielzoeker;
import model.IObserver;
import utils.IDataSeeder;

public class IndividueelPlaatsing extends PlaatsingSysteem  {

    public IndividueelPlaatsing(IDataSeeder dataSeeder) {
        super(dataSeeder);
    }

    @Override
    public int getNodigePlekken(Asielzoeker asielzoeker) {
        return 1;
    }

    @Override
    public void plaatsAsielzoker(AZC azc, Asielzoeker asielzoeker) {
        AZC herkomst = asielzoeker.getAzc();
        asielzoeker.getAzc().removeAsielzoeker(asielzoeker);
        asielzoeker.setAzc(azc);
        azc.addAsielzoeker(asielzoeker);
        notifyObservers(herkomst,azc,asielzoeker);
    }

    @Override
    public void notifyObservers(AZC bestemming,AZC herkomst,Asielzoeker asielzoeker) {
        for (IObserver observer : getObservers()){
            observer.update(bestemming,herkomst,asielzoeker,"Plaatsing");
        }
    }
}
