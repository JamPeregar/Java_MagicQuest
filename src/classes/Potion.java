package classes;

public class Potion extends AbstractItem{
    private int hp_effect = 10;
    public Potion(final String name, final String descr) {
        super(name, descr);
    }
    public Potion(final String name, final String descr, final String effect) {
        super(name, descr, effect);
    }

    @Override
    public void useCase(Entity user) {
        if (!this.wasUsed()) {
            System.out.println(user.getName() + " выпил(а) зелье: " + this.getEffect());
            this.setUsed();
        } else {
            System.out.println("Эта минзурка оказалась пуста...");
        }
    }
}
