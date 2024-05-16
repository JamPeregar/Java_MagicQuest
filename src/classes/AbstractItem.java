package classes;

public abstract class AbstractItem {
    private String name;
    private String descr;
    private String effect;
    private boolean isUsed = false;

    public AbstractItem() {
        this.name = "Default Item";
        this.descr = "Default item zero constructor";
        this.effect = "Ничего не произошло";
        //this.inventory = inventory;
    }

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

    public void setUsed() {
        this.isUsed = !this.isUsed;
    }

    public String getEffect() {
        return effect;
    }

    public abstract void useCase(Entity user); // Когда предмет будет использован персонажем.

    @Override
    public String toString() {
        return "Предмет: '" + name + '\'' +
                ", Описание: " + descr;
    }
}
