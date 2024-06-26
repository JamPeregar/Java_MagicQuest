package locations;
import classes.*;

import java.io.Serializable;
import java.util.ArrayList;

public class Home extends AbstractLocation implements Serializable {

    public Home() {
        super("Дом", "Вы находитесь в доме волшебника. Здесь пахнет магией и древними книгами.\nПовсюду расставлены странные артефакты и колбы с загадочными жидкостями.\nМягкий свет от ламп освещает помещение, создавая уютную, но немного таинственную атмосферу.");
        initializeItems();
        initializeNPCs();
        initializeObjects();
    }

    @Override
    public void initializeItems() {
        AbstractItem water = new Water("Пузырёк воды", "H2o или просто вода, не забывайте увлажнять организм!", "Получен заряд бодрости");
        AbstractItem potion = new Potion("Странное зелье", "Загадочный напиток, горький запах");
        AbstractItem potion2 = new Potion("Целебное зелье", "Выглядит здорОво", "Здоровье восстановлено");
        this.addItem(water);
        this.addItem(potion);
        this.addItem(potion2);
    }

    @Override
    public void initializeNPCs() {
        ArrayList<String> wizardQuotes = new ArrayList<>();
        wizardQuotes.add("Добро пожаловать в мой дом!");
        wizardQuotes.add("Не трогай этот артефакт, он очень опасен!");
        wizardQuotes.add("Если ты здесь, значит, у тебя есть вопросы.");
        NonPlayableChar wizard = new NonPlayableChar("Волшебник", "Старый мудрый волшебник с длинной бородой.", wizardQuotes);
        this.addNPC(wizard);
    }

    @Override
    public void initializeObjects(){
        Furniture chair = new Furniture("Деревянный стул","Обычный добротный деревянный стул");
        this.addObject(chair);
        Furniture table = new Furniture("Деревянный стол","Качественный деревянный стол из необычной породы дерева"){
            private boolean taken = false;
            @Override
            public void interract(Entity interractor) {
                if (!taken) {
                    AbstractItem item = new Potion();
                    interractor.giveItem(item);
                    System.out.println("На столе найден: " + item.getName());
                    taken = true;
                } else {
                    System.out.println("Стол уже осмотрен.");
                }
            }
        };
        this.addObject(table);
    }
}
