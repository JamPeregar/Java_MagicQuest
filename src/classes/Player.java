package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player extends Entity{
    private static Player player; // Only 1 player
    private Map<String, AbstractItem> pubinventory = new HashMap<>();
    private ArrayList<AbstractQuest> questlist = new ArrayList<>();


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

    public AbstractQuest giveQuest(AbstractQuest quest) {
        for (AbstractQuest myquest : this.questlist) { // Перебор всех квестов
            if (quest.getName().compareTo(myquest.getName()) == 0) { // Если нашли нужный квест
                return null;
            }
        }
        this.questlist.add(quest); // Добавляем его в список квестов
        return quest;
    }

    public AbstractQuest removeQuest(String questname) {
        for (AbstractQuest quest : this.questlist) { // Перебор всех квестов
            if (questname.compareTo(quest.getName()) == 0) { // Если нашли нужный квест
                this.questlist.remove(quest); // Удаляем его из списка квестов
                return quest; // Возвращаем квест
            }
        }
        return null; // Если квест не найден, возвращаем null
    }

    public AbstractQuest updateQuest(String questname, String update, boolean isReplace) {
        for (AbstractQuest quest : this.questlist) { // Перебор всех квестов
            if (questname.compareTo(quest.getName()) == 0) { // Если нашли нужный квест
                if (isReplace) {
                    quest.setBrief(update);
                } else {
                    quest.addBrief(update);
                }// Удаляем его из списка квестов
                return quest; // Возвращаем квест
            }
        }
        return null; // Если квест не найден, возвращаем null
    }

    public String getQuestBrief(String questname) {
        for (AbstractQuest quest : this.questlist) { // Перебор всех квестов
            if (questname.compareTo(quest.getName()) == 0) { // Если нашли нужный квест
                return quest.getBrief();
            }
        }
        return null; // Если квест не найден, возвращаем null
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
                System.out.println("\t" + obj);
            }
        } else {System.out.println("Пусто!");}
    }

}
