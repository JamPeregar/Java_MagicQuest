package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Location extends AbstractLocation { // Объявление класса Location, который наследуется от AbstractLocation
    //private List<Item> items; // Хранение предметов в текущей локации

    public Location(String name, String descr) { // Конструктор класса Location
        super(name, descr); // Вызов конструктора суперкласса AbstractLocation
        this.exits = new HashMap<>(); // Инициализация карты для хранения выходов
        //this.items = new ArrayList<>(); // Инициализация списка для хранения предметов
    }

}
