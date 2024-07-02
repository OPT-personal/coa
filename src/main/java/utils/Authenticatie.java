package utils;

import model.Gebruiker;

import java.util.Scanner;

public class Authenticatie {
    private static Authenticatie instance = null;

    private Gebruiker actieveGebruiker;

    private Authenticatie() {
        setActieveGebruiker(null);
    }

    public static Authenticatie getInstance() {

        if (instance == null) {
            instance = new Authenticatie();
        }

        return instance;
    }

    public Gebruiker getActieveGebruiker() {
        return actieveGebruiker;
    }

    private void setActieveGebruiker(Gebruiker gebruiker) {
        this.actieveGebruiker = gebruiker;
    }

    public boolean isIngelogd() {
        return getActieveGebruiker() != null;
    }

    public void login() {

        DataSeeder seeder = DataSeeder.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Voer je ID: ");

        while (!isIngelogd()) {

            int ID = scanner.nextInt();
            setActieveGebruiker(seeder.getGebruiker(ID));

            if (isIngelogd()) {
                return;
            }

            System.out.print("Voer opnieuw in (onbekend ID): ");
        }
    }

    public void logout() {
        setActieveGebruiker(null);
    }
}

