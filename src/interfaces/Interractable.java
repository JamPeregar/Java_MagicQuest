package interfaces;

import classes.Entity;

public interface Interractable {

    default void interract(Entity user) {
        System.out.println(user.getName() + " пнул(а) некий объект...");
    }
}
