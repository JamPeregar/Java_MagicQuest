package classes;

public abstract class AbstractItem {
    private String name;
    private String descr;
    protected boolean isUsed = false;

    public AbstractItem(final String name, final String descr) {
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

    public boolean wasUsed() {
        return this.isUsed;
    }

    public abstract void useCase(Entity user); // Когда предмет будет использован персонажем.

    @Override
    public String toString() {
        return "Предмет{" +
                "Имя:'" + name + '\'' +
                ", Описание:'" + descr + '\'' +
                ", Использовано:" + isUsed +
                '}';
    }
}
