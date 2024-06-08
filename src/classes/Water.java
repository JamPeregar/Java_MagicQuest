package classes;

import java.io.Serial;
import java.io.Serializable;

public class Water extends AbstractItem implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private int hp_effect = 5;

    public Water() {
        //super();
        this.setName("Бутылка воды");
        this.setDescr("H2o или просто вода, не забывайте увлажнять организм!");
        this.setEffect("+ 5 к здоровью и 1 к красноречию!");
    }

    public Water(final String name, final String descr) {
        super(name, descr);
        this.setEffect("+ 5 к здоровью и красноречию!");
    }

    public Water(final String name, final String descr, final String effect) {
        super(name, descr, effect);
    }

    @Override
    public void useCase(Entity user) {
        if (!this.wasUsed()) {
            if (user.getHealth() < 100) {
                System.out.println(user.getName() + " промочил(а) горло: " + this.getEffect());
                user.addHealth(hp_effect);
                this.setUsed();
            } else {
                System.out.println(this.getName() + ": " + "Ты не хочешь пить");
            }
        } else {
            System.out.println("Этот стакан оказался пуст...");
        }
    }
}
