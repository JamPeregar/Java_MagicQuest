package classes;

import interfaces.Interractable;

import java.util.Iterator;

public class Furniture extends Entity implements Interractable {

    public Furniture() {
        super();
    }

    public Furniture(String name, String descr) {
        super(name, descr);
    }

    @Override
    public void trade(Entity trader, String itemName, boolean toTrader) {
        if (toTrader) {
            final Iterator iterator = this.inventory.iterator();
            while (iterator.hasNext()) {
                AbstractItem item = (AbstractItem) iterator.next();
                if (itemName.compareTo(item.getName()) == 0) { // Если нашли нужный предмет
                    trader.giveItem(item);
                    iterator.remove();
                }
            }
        } else {
            final Iterator iterator = trader.inventory.iterator();
            while (iterator.hasNext()) {
                AbstractItem item = (AbstractItem) iterator.next();
                if (itemName.compareTo(item.getName()) == 0) { // Если нашли нужный предмет
                    this.giveItem(item);
                    iterator.remove();
                }
            }
        }
    }

    @Override
    public void interract(Entity interractor) {
        System.out.println(interractor.getName() + " пнул(а) " + this.getName());
    }
}
