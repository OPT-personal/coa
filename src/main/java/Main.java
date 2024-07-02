import menu.Menu;
import utils.DataSeeder;

public class Main {
    public static void main(String[] args) {
        DataSeeder dataSeeder = DataSeeder.getInstance();
        while (true) {
            Menu menu = dataSeeder.getMenu();
            menu.toonEnHandelAf();
        }

    }
}
