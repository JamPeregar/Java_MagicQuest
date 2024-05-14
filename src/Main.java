import classes.*;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        out.println("Hello world!");
        Player p1 = Player.createPlayer("Nik", "Student");
        Player p2 = Player.createPlayer("Rin", "Student");
        out.println(p1.toString());

        AbstractItem potion = new Potion("Странное зелье", "Загадочный напиток, горький запах");
        AbstractItem potion2 = new Potion("Странное зелье", "Загадочный напиток, горький запах", "Проклятие на понос");
        AbstractItem water = new Water("Пузырёк воды"
                , "H2o или просто вода, не забывайте увлажнять организм!"
                , "+ 1 к здоровью и красноречию!");
        AbstractItem water2 = new Water("Фляга тухлой воды", "Тухлая вода - гадость! - 2 к здоровью и запаху из рта",
                "+ тошнота, - 1 к здоровью");
        AbstractItem potion3 = new Potion("Зелье невидимости", "Загадочный напиток, горький запах", "");

        p1.giveItem(water);
        p1.giveItem(water2);
        p2.giveItem(potion);
        p2.giveItem(potion2);
        p1.showInventory();
        //p1.useItem("Фляга тухлой воды");
        //p1.useItem("Пузырёк воды");

        AbstractQuest q1 = new AbstractQuest("Гигиена", "Поковырять в носу") {
            @Override
            public void complete() {
                out.println("Вы ковыряете в носу");
                this.setFlag();
            }
        };
        out.println(q1);
        q1.complete();
        out.println(q1);

        Game game = new Game();
        game.game();
    }
}