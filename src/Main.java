import classes.*;

import java.util.ArrayList;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Player p1 = Player.createPlayer("Nik", "Student");

        AbstractItem water = new Water("Пузырёк воды", "H2o или просто вода, не забывайте увлажнять организм!");
        AbstractItem water2 = new Water("Фляга тухлой воды", "Тухлая вода - гадость! - 2 к здоровью и запаху из рта",
                "+ тошнота, - 1 к здоровью");
        AbstractItem poison = new Poison("Яд", "Загадочный напиток, горький запах", "Отравление");
        AbstractItem potion = new Potion();

        p1.giveItem(water);
        p1.giveItem(potion);
        Crate woodencrate = new Crate("Деревянный ящик", "Это определённо магическое дерево");
        woodencrate.interract(p1);

        NonPlayableChar wiz = new NonPlayableChar();
        p1.showInventory();
        wiz.showInventory();
        p1.trade(wiz, "Пузырёк воды", true);
        p1.showInventory();
        wiz.showInventory();
        p1.trade(woodencrate, "Яд", true);
        woodencrate.showInventory();
        Game game = new Game();
        game.game();
    }
}