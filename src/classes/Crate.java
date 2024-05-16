package classes;

import interfaces.Interractable;

public class Crate extends Furniture implements Interractable {

    public Crate() {
        super();
    }

    public Crate(String name, String descr) {
        super(name, descr);
    }

    @Override
    public void interract(Entity interractor) {
        AbstractItem item = new AbstractItem() {
            @Override
            public void useCase(Entity user) {
                System.out.println(super.getEffect());
            }
        };
        interractor.giveItem(item);
        System.out.println("В ящике найдено: " + item.getName());
    }
}
