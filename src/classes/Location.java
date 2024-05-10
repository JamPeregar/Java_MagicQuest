package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Location extends AbstractLocation { // Объявление класса Location, который наследуется от AbstractLocation
    private Map<String, Location> exits; // Хранение выходов из текущей локации
    //private List<Item> items; // Хранение предметов в текущей локации

    public Location(String name, String descr) { // Конструктор класса Location
        super(name, descr); // Вызов конструктора суперкласса AbstractLocation
        this.exits = new HashMap<>(); // Инициализация карты для хранения выходов
        //this.items = new ArrayList<>(); // Инициализация списка для хранения предметов
    }

    // Метод добавления выхода из текущей локации
    public void addExit(String direction, Location destination) {
        exits.put(direction, destination);
    }

    // Метод для получения описания локации
    @Override
    public String toString() {

        StringBuilder description = new StringBuilder(super.toString()); // Получение описания от суперкласса
        description.append("\nПереходы:"); // Добавление информации о выходах
        for (String direction : exits.keySet()) { // Перебор всех выходов
            description.append("\n").append(direction); // Добавление информации о каждом выходе
        }

        /*description.append("\nОбъекты в локации:"); // Добавление информации о предметах
        for (Item item : items) { // Перебор всех предметов
            description.append("\n").append(item.getName()); // Добавление информации о каждом предмете
        }*/

        return description.toString(); // Возврат полного описания
    }

    // Метод для перехода в другую локацию
    public Location go(String direction) {
        return exits.get(direction); // Возвращаем локацию, соответствующую указанному направлению
    }

    // Получение списка выходов из текущей локации
    public Map<String, Location> getExits() {
        return exits;
    }

    // Метод для добавления предмета в локацию
    /*public void addItem(Item item) {
        items.add(item); // Добавляем предмет в список предметов текущей локации
    }*/

    // Метод для взятия предмета из локации
    /*public Item takeItem(String itemName) {
        for (Item item : items) { // Перебор всех предметов в локации
            if (item.getName().equalsIgnoreCase(itemName)) { // Если нашли нужный предмет
                items.remove(item); // Удаляем его из списка предметов
                return item; // Возвращаем предмет
            }
        }
        return null; // Если предмет не найден, возвращаем null
    }*/
}
