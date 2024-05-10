import classes.AbstractItem;
import classes.Player;
import classes.Potion;
import classes.Water;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        out.println("Hello world!");
        Player p1 = Player.createPlayer("Nik", "Student");
        out.println(p1.toString());

        AbstractItem potion = new Potion("Странное зелье", "Загадочный напиток, горький запах");
        AbstractItem water = new Water("Пузырёк воды", "H2o или просто вода, не забывайте увлажнять организм!");

        p1.giveItem(water);
        p1.giveItem(potion);
        p1.showInventory();
        p1.useItem("Пузырёк воды");
    }
}