package classes;

import java.io.Serial;
import java.io.Serializable;

public abstract class AbstractItem implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
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

    public void setName(final String rename) {
         this.name = rename;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(final String redescr) {
        this.descr = redescr;
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

    public void setEffect(final String reeffect) {
        this.effect = reeffect;
    }

    public abstract void useCase(Entity user); // Когда предмет будет использован персонажем.

    @Override
    public String toString() {
        return "Предмет: '" + name + '\'' +
                ", Описание: " + descr;
    }
}
