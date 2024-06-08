package classes;

import java.io.Serial;
import java.io.Serializable;

public class Potion extends AbstractItem implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private int hp_effect = 10;

    public Potion() {
        this.setName("Странное зелье");
        this.setDescr("Таинственное зелье, с древними знаками на керамической оболочке и светящейся жидкостью внутри...");
        this.setEffect("+ 5 к здоровью и 1 к красноречию!");
    }

    public Potion(final String name, final String descr) {
        super(name, descr);
    }
    public Potion(final String name, final String descr, final String effect) {
        super(name, descr, effect);
    }

    @Override
    public void useCase(Entity user) {
        if (!this.wasUsed()) {
            if (user.getHealth() + hp_effect < 100) {
                System.out.println(user.getName() + " выпил(а) зелье: " + this.getEffect());
                user.addHealth(hp_effect);
                this.setUsed();
            } else {
                System.out.println(this.getName() + ": " + "Делом займись, пьёшь всякую *?%$ю");
            }
        } else {
            System.out.println("Эта минзурка оказалась пуста...");
        }
    }
}
