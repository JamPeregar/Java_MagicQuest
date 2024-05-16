package classes;

import interfaces.Interractable;

public class Furniture extends Entity implements Interractable {

    public Furniture() {
        super();
    }

    public Furniture(String name, String descr) {
        super(name, descr);
    }

    @Override
    public AbstractItem trade(Entity trader, String itemName, boolean toTrader) {
        AbstractItem item = super.trade(trader, itemName, toTrader);
        if (item != null) {
            System.out.println(trader.getName() + " положил(а) " + itemName + " в(на) " + this.getName());
            return item;
        } else {
            return null;
        }
    }

    @Override
    public void interract(Entity interractor) {
        System.out.println(interractor.getName() + " пнул(а) " + this.getName());
    }
}
