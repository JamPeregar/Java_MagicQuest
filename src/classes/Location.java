package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Location extends AbstractLocation { // Объявление класса Location, который наследуется от AbstractLocation

    public Location(String name, String descr) { // Конструктор класса Location
        super(name, descr); // Вызов конструктора суперкласса AbstractLocation
        this.exits = new HashMap<>(); // Инициализация карты для хранения выходов

    }

}
