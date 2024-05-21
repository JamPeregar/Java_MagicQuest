package locations;
import classes.*;

public class Home extends AbstractLocation {

    public Home() {
        super("Дом", "Вы находитесь в доме волшебника. Здесь пахнет магией и древними книгами. Повсюду расставлены странные артефакты и колбы с загадочными жидкостями. Мягкий свет от ламп освещает помещение, создавая уютную, но немного таинственную атмосферу.");
        initializeItems();
        initializeNPCs();
    }


    private void initializeItems() {
        AbstractItem water = new Water("Пузырёк воды", "H2o или просто вода, не забывайте увлажнять организм!", "Получен заряд бодрости");
        this.addItem(water);
    }

    // Метод для инициализации NPC (пока пустой, для будущего расширения)
    private void initializeNPCs() {

    }
}
