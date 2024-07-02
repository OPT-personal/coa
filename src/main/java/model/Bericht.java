package model;

public class Bericht {
    private AZC herkomstAZC;
    private String type;
    private Asielzoeker asielzoeker;
    private AZC bestemmingAZC;

    public Bericht(AZC herkomstAZC, String type, Asielzoeker asielzoeker, AZC bestemmingAZC) {
        this.herkomstAZC = herkomstAZC;
        this.type = type;
        this.asielzoeker = asielzoeker;
        this.bestemmingAZC = bestemmingAZC;

    }

    public AZC getHerkomstAZC() {
        return herkomstAZC;
    }

    public AZC getBestemmingAZC() {
        return bestemmingAZC;
    }

    public Asielzoeker getAsielzoeker() {
        return asielzoeker;
    }
}
