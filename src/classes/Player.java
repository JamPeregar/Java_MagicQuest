package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player extends Entity{
    private static Player player; // Only 1 player
    private Map<String, AbstractItem> pubinventory = new HashMap<>();


    private Player(String name, String descr) {
        super(name, descr);
    }
    //Реализация синглетона - игрок всё равно один.
    public static Player createPlayer(String name, String descr) {
        if (player == null) {
            player = new Player(name, descr);
        } else
        {
            System.out.println("Игрок уже существует!!");
        }
        return player;
    }
    @Override
    public void giveItem(AbstractItem item) {
        this.inventory.add(item);
        pubItems(inventory);
    }

    private void pubItems(ArrayList<AbstractItem> inv) {
        // Может сделать отдельный Map с именами и количеством?
    }

    @Override
    public void showInventory() {
        System.out.println("Содержимое вашего инвентаря:");
        if (!inventory.isEmpty()) {
            for (AbstractItem obj : inventory) {
                System.out.println(obj);
            }
        } else {System.out.println("Пусто!");}
    }

}
