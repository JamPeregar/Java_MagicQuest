package classes;

import interfaces.Interractable;

import java.io.Serial;
import java.io.Serializable;
import java.util.Iterator;

public class Furniture extends Entity implements Interractable , Serializable{
    @Serial
    private static final long serialVersionUID = 1L;


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
