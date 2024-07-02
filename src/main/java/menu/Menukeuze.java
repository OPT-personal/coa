package menu;

public class Menukeuze {

    int keuze;
    String titel;
    boolean extraLegeRegel;
    IActie actie;

    public Menukeuze(int keuze, String titel, boolean extraLegeRegel, IActie actie) {
        setKeuze(-1);
        setKeuze(keuze);
        setTitel(titel);
        setExtraLegeRegel(extraLegeRegel);
        setActie(actie);
    }

    public Menukeuze(String titel, IActie actie) {
        this(-1, titel, false, actie);
    }

    public Menukeuze(int keuze, String titel, IActie actie) {
        this(keuze, titel, false, actie);
    }

    public int getKeuze() {
        return this.keuze;
    }

    public void setKeuze(int keuze) {

        if ((keuze == -1) || (this.keuze == -1)) {
            this.keuze = keuze;
        }
    }

    private void setTitel(String titel) {
        this.titel = titel;
    }

    private void setExtraLegeRegel(boolean extra) {
        this.extraLegeRegel = extra;
    }

    private void setActie(IActie actie) {
        this.actie = actie;
    }

    public void toon() {

        if (extraLegeRegel) {
            System.out.println();
        }

        System.out.printf("%2d. %s%n", this.keuze, this.titel);
    }

    public void voerActieUit() {

        if (actie != null) {
            actie.voerActieUit();
        } else {
            System.out.println("Er is geen actie gedefinieerd voor deze menukeuze.");
        }
    }
}