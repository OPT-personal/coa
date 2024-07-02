package menu;

import model.*;
import utils.DataSeeder;

import javax.xml.crypto.Data;
import java.util.Scanner;

public class ActieRegisterNieuweGezin implements IActie {

    @Override
    public void voerActieUit() {
        Scanner scanner = new Scanner(System.in);
        DataSeeder seeder = DataSeeder.getInstance();

        boolean isKlaar = false;
        Gezin gezin = new Gezin();
        while(!isKlaar){
            System.out.print("Voer alstublieft de naam in: ");
            String naam = scanner.nextLine();

            System.out.print("Voer alstublieft de leeftijd in: ");
            int leeftijd = scanner.nextInt();

            System.out.print("Voer alstublieft het geslacht in: ");
            String gender = scanner.next();

            System.out.print("Voer alstublieft het land van herkomst in: ");
            String landNaam = scanner.next();


            System.out.print("Voer alstublieft de ID in: ");

            Land land = seeder.getLand(landNaam);

            AZC terApple = seeder.getAZC("Ter Apple");

            Asielzoeker asielzoeker = new GewoneAsielzoeker(naam,leeftijd,gender,land, seeder.getAsielzoekerID(),terApple);

            terApple.addAsielzoeker(asielzoeker);
            seeder.addGebruiker(asielzoeker);
            gezin.voegLidToe(asielzoeker);
            asielzoeker.setGezin(gezin);

            System.out.println("Is er meer leden? (j/n)");
            String antwoord = scanner.nextLine();
            if (antwoord.equals("j")){
                isKlaar = true;
            }


        }
    }
}
