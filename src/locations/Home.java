package locations;
import classes.*;

public class Home extends AbstractLocation {

    public Home() {
        super("Дом", "Вы находитесь в доме волшебника. Здесь пахнет магией и древними книгами. Повсюду расставлены странные артефакты и колбы с загадочными жидкостями. Мягкий свет от ламп освещает помещение, создавая уютную, но немного таинственную атмосферу.");
        initializeItems();
        initializeNPCs();
    }

    @Override
    public void initializeItems() {
        AbstractItem water = new Water("Пузырёк воды", "H2o или просто вода, не забывайте увлажнять организм!", "Получен заряд бодрости");
        this.addItem(water);
    }

    @Override
    public void initializeNPCs() {

    }
}
