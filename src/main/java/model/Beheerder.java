package model;

import menu.Menu;
import utils.DataSeeder;

public class Beheerder extends Gebruiker {
    public Beheerder(int ID, String naam) {
        super(naam,ID);

    }

    @Override
    public Menu getMenu() {
        return DataSeeder.getInstance().getBeheerderMenu();
    }
}
