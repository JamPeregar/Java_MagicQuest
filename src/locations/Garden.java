package locations;
import classes.*;


import java.util.HashMap;

public class Garden extends AbstractLocation {

    public Garden() {
        super("Сад", "Вы находитесь в уютном саду, окруженном цветущими растениями и ароматными цветами. Птицы щебечут на деревьях, а солнечные лучи проникают сквозь листву, создавая игривые тени на земле.");
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
