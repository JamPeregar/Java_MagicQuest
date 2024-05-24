package interfaces;

import classes.Entity;

public interface Interractable {
    String getName();

    default void interract(Entity user) {
        System.out.println(user.getName() + " пнул(а) некий объект...");
    }
}
