import classes.*;

import java.util.ArrayList;

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
        //p1.useItem("Фляга тухлой воды");
        //p1.useItem("Пузырёк воды");

        AbstractQuest q1 = new AbstractQuest("Гигиена", "Поковырять в носу") {
            @Override
            public void complete() {
                out.println("Вы ковыряете в носу");
                this.setFlag();
            }
        };
//        out.println(q1);
//        q1.complete();
//        out.println(q1);

//        Game game = new Game();
//        game.game();
        ArrayList<String> wizquotes = new ArrayList<>(5);
        wizquotes.add("Приветсвтую, мой верный программист");
        wizquotes.add("Куда я дел свои очки?");
        wizquotes.add("Рад вас видеть");
        wizquotes.add("СинИмУс потАскИс!");
        NonPlayableChar defaulter = new NonPlayableChar();
        defaulter.speak();
        defaulter.speak();
        defaulter.speak();
        NonPlayableChar wizzard = new NonPlayableChar("Wizzard", "Definetly wizzard - wears a pyramid hat!", wizquotes);
        wizzard.speak();
        wizzard.speak();
        wizzard.speak();
        out.println("ТЕСТ ОБМЕНА");
        out.println("ИГРОК ДАЁТ ПЕРСУ ДО:");
        wizzard.showInventory();
        p1.showInventory();
        p1.trade(wizzard, water.getName(), true);
        out.println("ИГРОК ДАЁТ ПЕРСУ ПОСЛЕ:");
        wizzard.showInventory();
        p1.showInventory();

        p1.trade(wizzard, water.getName(), false);
        out.println("ПЕРС ДАЁТ ИГРОКУ ПОСЛЕ");
        wizzard.showInventory();
        p1.showInventory();
    }
}