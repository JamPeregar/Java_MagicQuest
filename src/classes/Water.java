package classes;

public class Water extends AbstractItem{
    public Water(final String name, final String descr) {
        super(name, descr);
    }

    public Water(final String name, final String descr, final String effect) {
        super(name, descr, effect);
    }

    @Override
    public void useCase(Entity user) {
        if (!this.wasUsed()) {
            System.out.println(user.getName() + " промочил(а) горло: " + this.effect);
            this.isUsed = true;
        } else {
            System.out.println("Этот стакан оказался пуст...");
        }
    }
}
