package classes;

public class Water extends AbstractItem{
    public Water(final String name, final String descr) {
        super(name, descr);
    }

    @Override
    public void useCase(Entity user) {
        if (!this.wasUsed()) {
            System.out.println(user.getName() +" промочил(а) горло: + 1 к здоровью и харизме!!");
            this.isUsed = true;
        } else {
            System.out.println("Этот стакан оказался пуст...");
        }
    }
}
