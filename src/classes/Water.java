package classes;

public class Water extends AbstractItem{
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
            System.out.println(user.getName() + " промочил(а) горло: " + this.getEffect());
            if (user.getHealth() < 100) {
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
