package classes;

import java.util.*;

public abstract class Entity {
    private final String name;
    private final String descr;
    private int hp = 100;
    protected ArrayList<AbstractItem> inventory= new ArrayList<>();

    public Entity() {
        this.name = "The Entity";
        this.descr = "Default entity";
        //this.inventory = inventory;
    }

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

    public int getHealth() {
        return hp;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void addHealth(final int points) {
        if (hp > 0 && hp <= 100) this.hp += points;
    }

    public void giveItem(AbstractItem item) {
        this.inventory.add(item);
        //this.pubinventory.put(item.getName(), 1);
    }

    public AbstractItem takeItem(String itemName) {
        for (AbstractItem item : this.inventory) { // Перебор всех предметов в инвентаре
            if (itemName.compareTo(item.getName()) == 0) { // Если нашли нужный предмет
                this.inventory.remove(item); // Удаляем его из списка предметов
                return item; // Возвращаем предмет
            }
        }
        return null; // Если предмет не найден, возвращаем null
    }

    public void trade(Entity trader, String itemName, boolean toTrader) {

        if (toTrader) {
            final Iterator iterator = this.inventory.iterator();
            while (iterator.hasNext()) {
                AbstractItem item = (AbstractItem) iterator.next();
                if (itemName.compareTo(item.getName()) == 0) { // Если нашли нужный предмет
                    trader.giveItem(item);
                    iterator.remove(); // Удаляем его из списка предметов
                }
            }
        } else {
            final Iterator iterator = trader.inventory.iterator();
            while (iterator.hasNext()) {
                AbstractItem item = (AbstractItem) iterator.next();
                if (itemName.compareTo(item.getName()) == 0) { // Если нашли нужный предмет
                    this.giveItem(item);
                    iterator.remove(); //Удаляем предмет
                }
            }
        } // Конец обмена
    }

    public void useItem(String itemname) {
        for (AbstractItem item : this.inventory) {
            if (itemname.compareTo(item.getName()) == 0 && !item.wasUsed()) {
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
        } else {
            System.out.println("Пусто!");
        }
    }

    @Override
    public String toString() {
        return "Entity{" +
                "Имя: " + name +
                ", Описание: " + descr + "]";
    }
}
