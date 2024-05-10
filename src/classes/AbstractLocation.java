package classes;

import java.util.Map;

public abstract class AbstractLocation {
    private final String name;
    private final String descr;
    Map<String, Location> exits; // Хранение выходов из текущей локации
    //private String[] paths;

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

    // Получение списка выходов из текущей локации
    public Map<String, Location> getExits() {
        return exits;
    }

    // Метод для перехода в другую локацию
    public Location go(String direction) {
        return exits.get(direction); // Возвращаем локацию, соответствующую указанному направлению
    }

    // Метод добавления выхода из текущей локации
    public void addExit(String direction, Location destination) {
        exits.put(direction, destination);
    }




    @Override
    public String toString() {
        StringBuilder description = new StringBuilder(); // Создание объекта StringBuilder
        description.append("\n").append(this.name).append(" теперь зона вашего прибывания.\n")
                .append("Характеристика места: ").append(this.descr); // Добавление информации о локации
        description.append("\nПереходы:"); // Добавление информации о выходах
        for (String direction : exits.keySet()) { // Перебор всех выходов
            description.append("\n").append(direction); // Добавление информации о каждом выходе
        }

        return description.toString(); // Возврат полного описания
    }


}
