package model;

import menu.Menu;
import utils.DataSeeder;

public class AZCMedewerker extends Gebruiker {
    private AZC azc;

    public AZCMedewerker(int ID, String naam, AZC azc) {
        super(naam,ID);
    }

    @Override
    public Menu getMenu() {
        return DataSeeder.getInstance().getAZCMedewerkerMenu();
    }

    public AZC getAzc() {
        return azc;
    }
}
