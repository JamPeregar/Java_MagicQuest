package classes;

public abstract class AbstractItem {
    protected String name;
    protected String descr;
    protected String effect;
    protected boolean isUsed = false;

    public AbstractItem(final String name, final String descr) {
        this.name = name;
        this.descr = descr;
        this.effect = "Ничего не произошло";
        //this.inventory = inventory;
    }

    public AbstractItem(final String name, final String descr, final String effect) {
        this.name = name;
        this.descr = descr;
        this.effect = effect;
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
