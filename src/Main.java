import classes.*;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        out.println("Hello world!");
        Player p1 = Player.createPlayer("Nik", "Student");
        Player p2 = Player.createPlayer("Rin", "Student");
        out.println(p1.toString());

        AbstractItem potion = new Potion("Странное зелье", "Загадочный напиток, горький запах");
        AbstractItem water = new Water("Пузырёк воды", "H2o или просто вода, не забывайте увлажнять организм!");
        AbstractItem water2 = new Water("Пузырёк воды", "H2o или просто вода, не забывайте увлажнять организм!");

        p1.giveItem(water);
        p2.giveItem(potion);
        p1.showInventory();
        p1.useItem("Пузырёк воды");
        AbstractItem potion2 = new Potion("Лечебное зелье", "Здоровый напиток");
        Location l1 = new Location("Гостиная", "Хорошее место, чтобы отдохнуть");
        Location l2 = new Location("Ванная", "Популярное место для соблюдения гигиенических процедур!");
        l1.addItem(potion2);
        l1.addExit("Living room", l2);
        l2.addExit("Bath room", l1);
        out.println(l1 + "\n" + l2);

        Game gameStart = new Game();
        gameStart.game();
    }
}