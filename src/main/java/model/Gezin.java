package model;

import java.util.ArrayList;
import java.util.List;

public class Gezin {
    private List<Asielzoeker> leden;

    public Gezin() {
        this.leden = new ArrayList<>();
    }

    public void voegLidToe(Asielzoeker asielzoeker) {
        this.leden.add(asielzoeker);
    }

    public List<Asielzoeker> getLeden() {
        return this.leden;
    }
}
