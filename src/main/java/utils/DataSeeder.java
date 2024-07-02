package utils;

import menu.*;
import model.*;
import model.kamersysteem.*;

import java.util.ArrayList;

public class DataSeeder implements IDataSeeder {
    private static DataSeeder instance = null;
    private final ArrayList<Gemeente> gemeentes;
    private final ArrayList<Gebruiker> gebruikers;
    private final ArrayList<Menu> menus;
    private final ArrayList<Land> landen;
    private int stopKeuze;
    private int asielzoekerID;


    private DataSeeder() {
        gemeentes = new ArrayList<>();
        gebruikers = new ArrayList<>();
        menus = new ArrayList<>();
        landen = new ArrayList<>();
        asielzoekerID = 3000;
        initialize();
    }

    public static DataSeeder getInstance() {
        if (instance == null) {
            instance = new DataSeeder();
        }

        return instance;
    }

    private void initialize() {

        voegGemeenteToe("Den Haag", 566221);
        voegGemeenteToe("Leiden", 130108);
        voegGemeenteToe("Delft", 109577);
        voegGemeenteToe("Wassenaar", 27100);
        voegGemeenteToe("Westerwolde", 25000);

        voegLandToe("India", true);
        voegLandToe("Jemen", false);

        Kamer[] kamers1 = new Kamer[]{new GezinKamer(10),new IndivueelKamer(1),new JongerenKamer(20),new NormaleKamer(20)};

        voegAZC("Den Haag", "Laan van Meedervoort");
        voegKamers(kamers1,"Laan van Meedervoort");

        voegAZC("Den Haag", "Regulusweg");
        voegAZC("Leiden", "Haagse Schouwweg");
        voegAZC("Leiden", "Smaragdlaan");
        voegAZC("Wassenaar", "Wassenaar");
        voegAZC("Delft", "Kleveringweg");
        voegAZC("Delft", "Manderspark");

        voegAZC("Westerwolde", "Ter Apple");

        voegBeheerderToe(2000, "Justin");
        voegCOAMedewerkerToe(1000, "COAMedewerker");



        voegAsielzoekertoeTerApple("asiel1", 20, "man", "India");
        voegAsielzoekertoeTerApple("asiel2", 40, "vrouw", "Jemen");


        this.stopKeuze = 9;
        Menukeuze stop = new Menukeuze(stopKeuze,"Terminate",false,new ActieStop());
        Menukeuze logout = new Menukeuze(stopKeuze - 1,"Logout",true,new ActieLogout());


        Menu auth = new Menu("Authenticatie");
        auth.voegMenukeuzeToe(new Menukeuze("Login", new ActieLogin()));
        auth.voegMenukeuzeToe(stop);
        menus.add(auth);


        Menu beheederHoofdMenu = new Menu("Welkom beheerder.");
        beheederHoofdMenu.voegMenukeuzeToe(new Menukeuze("landen gegevens", null));
        beheederHoofdMenu.voegMenukeuzeToe(new Menukeuze("Gemeente & AZC gegevens", new ActieToonGemeenteGegevens()));
        beheederHoofdMenu.voegMenukeuzeToe(new Menukeuze("Uitkering rapportages", null));
        beheederHoofdMenu.voegMenukeuzeToe(new Menukeuze("Uitkering rapportage genereren", null));
        beheederHoofdMenu.voegMenukeuzeToe(logout);
        beheederHoofdMenu.voegMenukeuzeToe(stop);

        menus.add(beheederHoofdMenu);

        Menu AsielzoekerHoofdMenu = new Menu("Welcome asielzoeker.");
        AsielzoekerHoofdMenu.voegMenukeuzeToe(new Menukeuze("Persoonlijk gegevens", null));
        AsielzoekerHoofdMenu.voegMenukeuzeToe(new Menukeuze("Verhuizing registeren", null));
        menus.add(AsielzoekerHoofdMenu);

        Menu COAMedewerkerHoofdMenu = new Menu("Welcome COA Medewerker.");
        COAMedewerkerHoofdMenu.voegMenukeuzeToe(new Menukeuze("Nieuwe individueel asielzoeker toevoegen", new ActieRegisterNieuweAsiezoeker()));
        COAMedewerkerHoofdMenu.voegMenukeuzeToe(new Menukeuze("Nieuwe gezin toevoegen", new ActieRegisterNieuweGezin()));
        COAMedewerkerHoofdMenu.voegMenukeuzeToe(new Menukeuze("Plaats asielzoeker", new ActiePlaatsAsielzoeker()));
        COAMedewerkerHoofdMenu.voegMenukeuzeToe(new Menukeuze("Vertrek asielzoeker", null));
        COAMedewerkerHoofdMenu.voegMenukeuzeToe(new Menukeuze("Dossier bijwerken", null));
        menus.add(COAMedewerkerHoofdMenu);

        Menu AZCMedewerkerHoofdMenu = new Menu("Welcome AZC Medewerker");
        AZCMedewerkerHoofdMenu.voegMenukeuzeToe(new Menukeuze("BerichtenBox", null));
        AZCMedewerkerHoofdMenu.voegMenukeuzeToe(new Menukeuze("Asielzoeker kamer plaatsing", null));
        menus.add(AZCMedewerkerHoofdMenu);


    }

    public int getAsielzoekerID() {
        return asielzoekerID++;
    }


    private void voegLandToe(String landNaam, boolean isVeilig) {
        landen.add(new Land(landNaam, isVeilig));
    }

    public Land getLand(String landNaam) {
        Land gewensteLand = null;
        for (Land land : landen) {
            if (land.getNaam().equals(landNaam)) {
                gewensteLand = land;
            }
        }
        return gewensteLand;
    }

    private void voegAsielzoekertoeTerApple(String naam, int leeftijd, String gender, String landNaam) {
        AZC azc = getAZC("Ter Apple");
        Land land = getLand(landNaam);
        Asielzoeker asielzoeker = new GewoneAsielzoeker(naam, leeftijd, gender, land,getAsielzoekerID(),azc);
        azc.addAsielzoeker(asielzoeker);
        addGebruiker(asielzoeker);
    }

    public void addGebruiker(Asielzoeker asielzoeker) {
        gebruikers.add(asielzoeker);
    }

    public AZC getAZC(String azcNaam) {
        AZC nodigeAZC = null;
        for (Gemeente gemeente : gemeentes) {
            ArrayList<AZC> azcs = gemeente.getAZCS();
            for (AZC azc : azcs) {
                if (azc.getNaam().equals(azcNaam)) {
                    nodigeAZC = azc;
                }
            }
        }
        return nodigeAZC;
    }

    private void voegAZC(String gemeenteNaam, String AZCNaam) {
        Gemeente gemeente = getGemeente(gemeenteNaam);
        if (gemeente != null) {
            gemeente.voegAZCToe(new AZC(AZCNaam, gemeente));
        } else {
            System.out.println("Ongeldig gemeente naam");
        }
    }

    private void voegKamers(Kamer [] kamers, String azcNaam) {
        AZC azc = getAZC(azcNaam);
        azc.addKamer(kamers);
    }

    private void voegGemeenteToe(String naam, int aanatalInwoners) {
        gemeentes.add(new Gemeente(naam, aanatalInwoners));
    }

    private Gemeente getGemeente(String naam) {
        for (Gemeente gemeente : gemeentes) {
            if (gemeente.getNaam().equals(naam)) {
                return gemeente;
            }
        }
        return null;
    }

    public Gemeente[] getAllGemeentes() {
        Gemeente[] gemeentesArray = new Gemeente[gemeentes.size()];
        return gemeentes.toArray(gemeentesArray);
    }

    private void voegBeheerderToe(int ID, String naam) {
        gebruikers.add(new Beheerder(ID, naam));
    }

    private void voegCOAMedewerkerToe(int id, String naam) {
        gebruikers.add(new COAMedewerker(id, naam));
    }

    public int getStopKeuze() {
        return this.stopKeuze;
    }

    public Gebruiker getGebruiker(int ID) {
        for (Gebruiker gebruiker : gebruikers) {
            if (gebruiker.getID() == ID) {
                return gebruiker;
            }
        }
        return null;
    }

    public Menu getMenu() {
        Authenticatie auth = Authenticatie.getInstance();

        if (!auth.isIngelogd()) {
            return menus.get(0);
        } else {
            return auth.getActieveGebruiker().getMenu();
        }
    }

    public Menu getBeheerderMenu() {
        return this.menus.get(1);
    }

    public Menu getAsielzoekerMenu() {
        return this.menus.get(2);
    }

    public Menu getCOAMedewerkerMenu() {
        return this.menus.get(3);
    }

    public Menu getAZCMedewerkerMenu() {
        return this.menus.get(4);
    }


    public Land [] getLanden() {
        return landen.toArray(new Land[landen.size()]);
    }

}
