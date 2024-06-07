package classes;

public class Poison extends Potion{
    private int hp_effect = -10;
    private static final long serialVersionUID = 1L;

    public Poison() {
        this.setName("Яд");
        this.setDescr("Чёрный пузырёк с не менее тёмной жидкостью..");
        this.setEffect("Отравление!");
    }

    public Poison(final String name, final String descr) {
        super(name, descr);
    }

    public Poison(final String name, final String descr, final String effect) {
        super(name, descr, effect);
    }

    public Poison(final String name, final String descr, final String effect, final int hp_effect) {
        super(name, descr, effect);
        this.hp_effect = hp_effect;
    }

    @Override
    public void useCase(Entity user) {
        if (!this.wasUsed()) {
            System.out.println(user.getName() + " выпил(а) яд: " + this.getEffect());
            this.setUsed();
            user.addHealth(this.hp_effect);
        } else {
            System.out.println("Эта минзурка оказалась пуста...");
        }
    }
}
