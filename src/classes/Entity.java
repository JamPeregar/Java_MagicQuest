package classes;

import java.util.List;

public abstract class Entity {
    private final String name;
    private final String descr;

    private List<Object> inventory;

    public Entity(final String name, final String descr, List<Object> inventory) {
        this.name = name;
        this.descr = descr;
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "Имя: '" + name + '\'' +
                ", descr='" + descr + '\'' +
                ", Наличие вещей в инвентаре: " + inventory.isEmpty() +
                '}';
    }
}
