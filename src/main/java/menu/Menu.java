package menu;

import utils.DataSeeder;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private String titel;
    private final ArrayList<Menukeuze> menukeuzes;

    public Menu(String titel) {
        this.setTitel(titel);
        menukeuzes = new ArrayList<>();
    }

    public String getTitel() {
        return this.titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void voegMenukeuzeToe(Menukeuze menukeuze) {
        menukeuze.setKeuze(menukeuzes.size() + 1);
        this.menukeuzes.add(menukeuze);
    }

    private void toon() {

        System.out.println();
        System.out.printf("=== %s ===%n", getTitel());

        for (int i = 0; i < menukeuzes.size(); i++) {
            menukeuzes.get(i).toon();
        }

        System.out.println();
        System.out.print("Wat wilt u doen? Maak een keuze: ");
    }

    private void voerMenukeuzeUit(int keuze) {

        for (Menukeuze menukeuze : menukeuzes) {

            if (menukeuze.getKeuze() == keuze) {
                menukeuze.voerActieUit();
                return;
            }
        }

        System.out.println("Onbekende keuze. Kies opnieuw.");
    }

    public void toonEnHandelAf() {
        int exitKeuze = DataSeeder.getInstance().getStopKeuze();
        Scanner scanner = new Scanner(System.in);
        toon();
        voerMenukeuzeUit(scanner.nextInt());
    }
}
