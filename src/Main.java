import classes.*;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        out.println("Hello world!");
        Player p1 = Player.createPlayer("Nik", "Student");
        Player p2 = Player.createPlayer("Rin", "Student");
        out.println(p1.toString());

        AbstractItem potion = new Potion("Странное зелье", "Загадочный напиток, горький запах");
        AbstractItem water = new Water("Пузырёк воды"
                , "H2o или просто вода, не забывайте увлажнять организм!"
                , "+ 1 к здоровью и красноречию!");
        AbstractItem water2 = new Water("Фляга тухлой воды", "Тухлая вода - гадость! - 2 к здоровью",
                "+ тошнота, - 1 к здоровью");

        p1.giveItem(water);
        p1.giveItem(water2);
        p2.giveItem(potion);
        p1.showInventory();
        p1.useItem("Фляга тухлой воды");
        p1.useItem("Пузырёк воды");
    }
}