package model;

import menu.Menu;
import utils.DataSeeder;

public class COAMedewerker extends Gebruiker {
    public COAMedewerker(int ID, String naam) {
        super(naam,ID);
    }

    @Override
    public Menu getMenu() {
        return DataSeeder.getInstance().getCOAMedewerkerMenu();
    }
}
