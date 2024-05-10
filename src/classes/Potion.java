package classes;

public class Potion extends AbstractItem{

    public Potion(final String name, final String descr) {
        super(name, descr);
    }

    @Override
    public void useCase(Entity user) {
        if (!this.wasUsed()) {
            System.out.println("Зелье прибавило " + user.getName() + " + 2 к здоровью и 3 к харизме!!");
            this.isUsed = true;
        } else {
            System.out.println("Этот стакан оказался пуст...");
        }
    }
}
