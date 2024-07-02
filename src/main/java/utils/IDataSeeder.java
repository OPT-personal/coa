package utils;

import menu.*;
import model.*;

public interface IDataSeeder {
    static IDataSeeder getInstance() {
        return null;
    }

    int getAsielzoekerID();

    Land getLand(String landNaam);

    void addGebruiker(Asielzoeker asielzoeker);

    AZC getAZC(String azcNaam);

    Gemeente[] getAllGemeentes();

    int getStopKeuze();

    Gebruiker getGebruiker(int ID);

    Menu getMenu();

    Menu getBeheerderMenu();

    Menu getAsielzoekerMenu();

    Menu getCOAMedewerkerMenu();

    Menu getAZCMedewerkerMenu();

    Land[] getLanden();
}