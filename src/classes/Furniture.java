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
    public void interract(Entity interractor) {
        System.out.println(interractor.getName() + " пнул(а) " + this.getName());
    }
}
