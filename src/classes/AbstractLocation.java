package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class AbstractLocation {
    private final String name;
    private final String descr;
    //protected String[] paths;
    protected Map<String, AbstractLocation> exits; // Хранение выходов из текущей локации
    protected ArrayList<AbstractItem> localinventory= new ArrayList<>();
    protected ArrayList<NonPlayableChar> localNPCs= new ArrayList<>();

    public AbstractLocation(final String name, final String dscr, String[] paths) {
        this.name = name;
        this.descr = dscr;
        this.exits = new HashMap<>();
    }

    public AbstractLocation(final String name, final String dscr) {
        this.name = name;
        this.descr = dscr;
        this.exits = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return descr;
    }

    public AbstractLocation go(String direction) {  // Метод для перехода в другую локацию
        return exits.get(direction); // Возвращаем локацию, соответствующую указанному направлению
    }

    public Map<String, AbstractLocation> getExits() {
        return exits;
    }  // Получение списка выходов из текущей локации

    // Метод добавления выхода из текущей локации
    public void addExit(String direction, AbstractLocation destination) {
        exits.put(direction, destination);
    }

    public void addBidirectionalExit(String direction, AbstractLocation destination, String returnDirection) {
        this.addExit(direction, destination);
        destination.addExit(returnDirection, this);
    }


    // Метод для добавления предмета в локацию
    public void addItem(AbstractItem item) {
        localinventory.add(item); // Добавляем предмет в список предметов текущей локации
    }

    // Метод для добавления НПС в локацию
    public void addNPC(NonPlayableChar npc) {
        localNPCs.add(npc);
    }

    // Метод для получения локального инвентаря локации
    public ArrayList<AbstractItem> getLocalInventory() {
        return localinventory;
    }

    // Метод для взятия предмета из локации
    public AbstractItem takeItem(String itemName) {
        final Iterator iterator = this.localinventory.iterator();
        while (iterator.hasNext()) {
            AbstractItem item = (AbstractItem) iterator.next();
            if (itemName.compareTo(item.getName()) == 0) { // Если нашли нужный предмет
                iterator.remove(); // Удаляем его из списка предметов
                return item;
            }
        }
        return null; // Если предмет не найден, возвращаем null
    }

    public abstract void initializeItems();//Метод для инициазизации предметов

    // Метод для инициализации NPC
    public abstract void initializeNPCs();

    @Override
    public String toString() {

        StringBuilder description = new StringBuilder("\nЛокация: " + this.name + "\nОписание: " + this.descr);
        description.append("\nПереходы:"); // Добавление информации о выходах
        for (String direction : exits.keySet()) { // Перебор всех выходов
            description.append("\n").append(direction); // Добавление информации о каждом выходе
        }

        description.append("\nОбъекты в локации:"); // Добавление информации о предметах
        for (AbstractItem item : localinventory) { // Перебор всех предметов
            description.append("\n\t").append(item.getName()); // Добавление информации о каждом предмете
        }

        description.append("\nДоступные НПС в локации:"); // Добавление информации о предметах
        for (NonPlayableChar npc : localNPCs) { // Перебор всех предметов
            description.append("\n\t").append(npc.getName()); // Добавление информации о каждом предмете
        }

        return description.toString(); // Возврат полного описания
    }


}
