package classes;

public class Potion extends AbstractItem{

    public Potion(final String name, final String descr) {
        super(name, descr);
    }
    public Potion(final String name, final String descr, final String effect) {
        super(name, descr, effect);
    }

    @Override
    public void useCase(Entity user) {
        if (!this.wasUsed()) {
            System.out.println(user.getName() + " выпил(а) зелье: " + this.effect);
            this.isUsed = true;
        } else {
            System.out.println("Этот стакан оказался пуст...");
        }
    }
}
