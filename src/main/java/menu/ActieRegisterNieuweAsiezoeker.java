package menu;

import model.*;
import utils.DataSeeder;

import java.util.Scanner;

public class ActieRegisterNieuweAsiezoeker implements IActie {
    @Override
    public void voerActieUit() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Voer alstublieft de naam in: ");
        String naam = scanner.nextLine();

        System.out.print("Voer alstublieft de leeftijd in: ");
        int leeftijd = scanner.nextInt();

        System.out.print("Voer alstublieft het geslacht in: ");
        String gender = scanner.next();

        System.out.print("Voer alstublieft het land van herkomst in: ");
        String landNaam = scanner.next();


        DataSeeder dataSeeder = DataSeeder.getInstance();
        Land land = dataSeeder.getLand(landNaam);

        AZC terApple = dataSeeder.getAZC("Ter Apple");

        Asielzoeker asielzoeker = new GewoneAsielzoeker(naam,leeftijd,gender,land, dataSeeder.getAsielzoekerID(),terApple);

        terApple.addAsielzoeker(asielzoeker);
        dataSeeder.addGebruiker(asielzoeker);



    }
}
