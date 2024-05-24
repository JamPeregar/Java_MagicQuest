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
<<<<<<< HEAD
=======
        Crate demoncrate = new Crate("Адский ящик", "Это определённо адский камень") {
            @Override
            public void interract(Entity interractor) {
                AbstractItem item = new Poison();
                interractor.giveItem(item);
                System.out.println("В ящике найдено: " + item.getName());
            }
        };
        AbstractItem[] itemsforquest = {poison, water, potion};
>>>>>>> f29e15d583effd8914b9c9ccb5ab7dd298eba442
        woodencrate.interract(p1);

        NonPlayableChar wiz = new NonPlayableChar();
        ElementalQuest quest = new ElementalQuest("Test", "Testing");
        quest.addquestitem(itemsforquest);
        //p1.takeItem("Яд");
        p1.showInventory();
        out.println(quest.questcheck(p1));

    }
}