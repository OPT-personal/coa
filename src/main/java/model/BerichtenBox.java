package model;

import java.util.ArrayList;

public class BerichtenBox implements IObserver {
    private ArrayList<Bericht> box;

    public BerichtenBox() {
        this.box = new ArrayList<>();
    }

    public void removeBericht(Bericht bericht){
        box.remove(bericht);
    }

    @Override
    public void update(AZC bestemming ,AZC herkomst, Asielzoeker asielzoeker, String type) {
        box.add(new Bericht(herkomst, type, asielzoeker, bestemming ));
    }
}
