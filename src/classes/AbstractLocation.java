package classes;

import java.util.ArrayList;
import java.util.Map;

public class AbstractLocation {
    private final String name;
    private final String descr;
    //protected String[] paths;
    protected Map<String, Location> exits; // Хранение выходов из текущей локации
    protected ArrayList<AbstractItem> localinventory= new ArrayList<>();

    public AbstractLocation(final String name, final String dscr, String[] paths) {
        this.name = name;
        this.descr = dscr;
    }

    public AbstractLocation(final String name, final String dscr) {
        this.name = name;
        this.descr = dscr;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return descr;
    }

    public Location go(String direction) {  // Метод для перехода в другую локацию
        return exits.get(direction); // Возвращаем локацию, соответствующую указанному направлению
    }

    public Map<String, Location> getExits() {
        return exits;
    }  // Получение списка выходов из текущей локации

    // Метод добавления выхода из текущей локации
    public void addExit(String direction, Location destination) {
        exits.put(direction, destination);
    }

    // Метод для добавления предмета в локацию
    public void addItem(AbstractItem item) {
        localinventory.add(item); // Добавляем предмет в список предметов текущей локации
    }

    // Метод для получения локального инвентаря локации
    public ArrayList<AbstractItem> getLocalInventory() {
        return localinventory;
    }

    // Метод для взятия предмета из локации
    public AbstractItem takeItem(String itemName) {
        for (AbstractItem item : localinventory) { // Перебор всех предметов в локации
            if (item.getName().equals(itemName)) { // Если нашли нужный предмет
                localinventory.remove(item); // Удаляем его из списка предметов
                return item; // Возвращаем предмет
            }
        }
        return null; // Если предмет не найден, возвращаем null
    }

    @Override
    public String toString() {

        StringBuilder description = new StringBuilder("\nЛокация: " + this.name + "\nОписание: " + this.descr);
        description.append("\nПереходы:"); // Добавление информации о выходах
        for (String direction : exits.keySet()) { // Перебор всех выходов
            description.append("\n").append(direction); // Добавление информации о каждом выходе
        }

        description.append("\nОбъекты в локации:"); // Добавление информации о предметах
        for (AbstractItem item : localinventory) { // Перебор всех предметов
            description.append("\n").append(item.getName()); // Добавление информации о каждом предмете
        }

        return description.toString(); // Возврат полного описания
    }

}
