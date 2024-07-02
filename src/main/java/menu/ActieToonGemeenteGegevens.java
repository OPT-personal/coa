package menu;

import model.AZC;
import model.Gemeente;
import utils.DataSeeder;

public class ActieToonGemeenteGegevens implements IActie {
    @Override
    public void voerActieUit() {

        Gemeente[] gemeentes = DataSeeder.getInstance().getAllGemeentes();
        System.out.println();

        for (Gemeente gemeente : gemeentes) {
            System.out.println("Gemeente naam: " + gemeente.getNaam());
            System.out.println("Aantal inwoners: " + gemeente.getAantalInwoners());
            System.out.println("Aantal plaatsen: " + gemeente.getCapaciteit());
            System.out.println("Aantal beschikbaar plaatsen: " + gemeente.getAantalBeschikbaarPlaatsen());
            System.out.println("AZCS");
            for (AZC azc : gemeente.getAZCS()) {
                System.out.println("    naam: " + azc.getNaam());
                System.out.println("    Slaapplaatsen: " + azc.getCapaciteit());
                System.out.println("    Beschikbaar Slaapplaatsen: " + azc.getTotaalBeschikbaarSlaapplaatsen());
            }
            System.out.println();

        }
    }
}
