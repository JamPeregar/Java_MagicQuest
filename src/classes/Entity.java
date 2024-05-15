package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Entity {
    private final String name;
    private final String descr;
    protected ArrayList<AbstractItem> inventory= new ArrayList<>();

    public Entity(final String name, final String descr) {
        this.name = name;
        this.descr = descr;
        //this.inventory = inventory;
    }
    public String getName() {
        return name;
    }

    public String getDescr() {
        return descr;
    }

    public void giveItem(AbstractItem item) {
        this.inventory.add(item);
        //this.pubinventory.put(item.getName(), 1);
    }

    public AbstractItem takeItem(String itemName) {
        for (AbstractItem item : this.inventory) { // Перебор всех предметов в локации
            if (itemName.compareTo(item.getName()) == 0) { // Если нашли нужный предмет
                this.inventory.remove(item); // Удаляем его из списка предметов
                return item; // Возвращаем предмет
            }
        }
        return null; // Если предмет не найден, возвращаем null
    }

    public void useItem(String itemname) {
        for (AbstractItem item : this.inventory) {
            if (itemname.compareTo(item.getName()) == 0 && !item.wasUsed()) {
                item.useCase(this);
                break;
            }
        }
        for (AbstractItem item : this.inventory) {
            if (itemname.compareTo(item.getName()) == 0) {
                item.useCase(this);
                break;
            }
        }

    }

    public void showInventory() {
        if (!inventory.isEmpty()) {
            for (AbstractItem obj : inventory) {
                System.out.println(obj.getName());
            }
        }
    }

    @Override
    public String toString() {
        return "Entity{" +
                "Имя: " + name +
                ", Описание: " + descr + "]";
    }
}
