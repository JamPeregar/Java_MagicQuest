package classes;
import interfaces.Interractable;
import locations.*;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Scanner;

public class Game {

    private Garden garden;
    private Home home;
    private final int timeSleep = 1300;
    private AtticHomeWizard atticHW;
    private ElementalQuest quest1;
    private Player p1;


    //Controls game, catch player commands
    public void game() throws InterruptedException {

        {
            createPlayers();
            creationLocations();
            createTransitions();
            initializeQuests();
        }

        Scanner scanner = new Scanner(System.in);

        AbstractLocation currentLocation = home;//стартовая локация
        while (true) {
            System.out.println(currentLocation);
            System.out.println("""
                    \nСписок доступных команд:
                    \t1. перейти - (переход в другую локацию)
                    \t2. инвентарь - (показывает ваш инвентарь)
                    \t3. подобрать - (подобрать предмет)
                    \t4. использовать - (использовать предмет)
                    \t5. подойти к НПС
                    \t6. взаимодействовать - (взаимодействовать с объектом)""");
            System.out.print("> ");
            String command = scanner.nextLine();
            switch (capitalize(command.toLowerCase())){
                case "1":
                case "Перейти":
                    // Отображение доступных локаций с порядковыми номерами
                    System.out.println("Доступные локации для перехода:");
                    int index = 1;
                    Map<String, AbstractLocation> exits = currentLocation.getExits();
                    for (String direction : exits.keySet()) {
                        System.out.println("\t"+index + ". " + direction);
                        index++;
                    }
                    // Получение порядкового номера выбранной локации
                    System.out.println("Введите номер локации для перехода:");
                    int chosenLocationIndex = Integer.parseInt(scanner.nextLine());
                    if (chosenLocationIndex > 0 && chosenLocationIndex <= exits.size()) {
                        // Переход к выбранной локации
                        AbstractLocation nextLocation = null;
                        int count = 1;
                        for (Map.Entry<String, AbstractLocation> entry : exits.entrySet()) {
                            if (count == chosenLocationIndex) {
                                nextLocation = entry.getValue();
                                break;
                            }
                            count++;
                        }
                        if (nextLocation != null) {
                            currentLocation = nextLocation;
                            System.out.println("Вы прибыли в " + currentLocation.getName());
                            System.out.println(currentLocation.getDescription());
                        } else {
                            System.out.println("Ошибка при выборе локации.");
                        }
                    } else {
                        System.out.println("Неверный номер локации.");
                    }
                    Thread.sleep(timeSleep);
                    break;
                case "2":
                case "Инвентарь":
                    p1.showInventory();
                    Thread.sleep(timeSleep);
                    break;
                case "3":
                case "Подобрать":
                    // Отображение доступных предметов с порядковыми номерами
                    System.out.println("Доступные предметы для подбора:");
                    int itemIndex = 1;
                    List<AbstractItem> localInventory = currentLocation.getLocalInventory();
                    for (AbstractItem item : localInventory) {
                        System.out.println(itemIndex + ". " + item.getName());
                        itemIndex++;
                    }
                    // Получение порядкового номера выбранного предмета
                    System.out.println("Введите номер предмета, который хотите подобрать:");
                    int chosenItemIndex = Integer.parseInt(scanner.nextLine());
                    if (chosenItemIndex > 0 && chosenItemIndex <= localInventory.size()) {
                        // Подбор выбранного предмета
                        AbstractItem pickedItem = localInventory.get(chosenItemIndex - 1);
                        if (pickedItem != null) {
                            currentLocation.takeItem(pickedItem.getName());
                            p1.giveItem(pickedItem);
                            System.out.println("Вы подобрали: " + pickedItem.getName());
                        } else {
                            System.out.println("Ошибка при подборе предмета.");
                        }
                    } else {
                        System.out.println("Неверный номер предмета.");
                    }
                    Thread.sleep(timeSleep);
                    break;
                case "4":
                case "Использовать":
                    // Код для использования предмета
                    p1.showInventory();
                    System.out.println("Введите номер предмета, который хотите использовать:");
                    int selectedIndex = Integer.parseInt(scanner.nextLine());
                    if (selectedIndex >= 1 && selectedIndex <= p1.getInventory().size()) {
                        AbstractItem itemToUse = p1.getInventory().get(selectedIndex - 1); // Поиск предмета по индексу
                        p1.useItem(itemToUse.getName()); // Использование предмета
                    } else {
                        System.out.println("Неверный номер предмета.");
                    }
                    Thread.sleep(timeSleep);
                    break;
                case "5":
                case "Подойти к НПС":
                    System.out.println("Доступные НПС для взаимодействия:");
                    if (!currentLocation.getLocalNPCs().isEmpty()) {
                        for (int i = 0; i < currentLocation.getLocalNPCs().size(); i++) {
                            NonPlayableChar npc = currentLocation.getLocalNPCs().get(i);
                            System.out.println("\t"+ (i + 1) + ". " + npc.getName() + ": " + npc.getDescription());
                        }
                        System.out.println("Введите номер НПС, к которому хотите подойти:");
                        int npcIndex = Integer.parseInt(scanner.nextLine()) - 1;
                        if (npcIndex >= 0 && npcIndex < currentLocation.getLocalNPCs().size()) {
                            NonPlayableChar npc = currentLocation.getLocalNPCs().get(npcIndex);
                            System.out.println("\t1. Поговорить\n\t2. Принять квест\n\t3. Сдать квест");
                            System.out.print("> ");
                            String command2 = scanner.nextLine();
                            switch (capitalize(command2.toLowerCase())){
                                case "1":
                                    npc.speak();
                                    break;
                                case "2":
                                    System.out.println("Вы приняли квест: " + quest1.getName() + "\n" + quest1.getBrief());
                                    break;
                                case "3":
                                    if (quest1.questcheck(p1)) {
                                        System.out.println("Вы сдали квест: " + quest1.getName());
                                    } else {
                                        System.out.println("Вы еще не выполнили все условия для этого квеста.");
                                    }
                                    break;
                            }
                        } else {
                            System.out.println("Неверный номер НПС.");
                        }
                    } else {
                        System.out.println("В этой локации нет НПС.");
                    }
                    Thread.sleep(timeSleep);
                    break;

                case "6":
                case "Осмотреть объект":
                    System.out.println("Доступные объекты в локации:");
                    for (int i = 0; i < currentLocation.getLocalObjects().size(); i++) {
                        Interractable object = currentLocation.getLocalObjects().get(i);
                        System.out.println("\t"+(i + 1) + ". " + object.getName());
                    }
                    System.out.println("Введите номер объекта для взаимодействия:");
                    int objectIndex = Integer.parseInt(scanner.nextLine());
                    if (objectIndex > 0 && objectIndex <= currentLocation.getLocalObjects().size()) {
                        Interractable object = currentLocation.getLocalObjects().get(objectIndex - 1);
                        object.interract(p1);
                    } else {
                        System.out.println("Неверный номер объекта.");
                    }
                    Thread.sleep(timeSleep);
                    break;
                case "7":
                case"save":
                    p1.showInventory();
                    p1.save(p1.inventory);
                    break;
                case "8":
                case"load":
                    SavedGame lG = p1.load();
                    p1.inventory=lG.saveInventory;
                    break;

                default:
                    System.out.println("Неизвестная команда.");
                    Thread.sleep(timeSleep);
                    break;

            }

        }
    }
    private void creationLocations (){
        home = new Home();
        garden = new Garden();
        atticHW = new AtticHomeWizard();

    }

    private void createTransitions (){
        home.addBidirectionalExit("Сад", garden, "Дом волшебника");
        home.addBidirectionalExit("Чердак", atticHW, "Дом волшебника");
    }

    private void createPlayers(){
        p1 = Player.createPlayer("Nik", "Student");
    }

    private void initializeQuests(){
        quest1 = new ElementalQuest("Помощь волшебнику.", "Нужно найти и принести волшебнику: яд, воду и зелье.");
        AbstractItem poison = new Poison();
        AbstractItem water = new Water();
        AbstractItem potion = new Potion();
        AbstractItem[] itemsforquest1 = {poison, water, potion};
        quest1.addquestitem(itemsforquest1);

    }

    private static String capitalize(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return inputString;
        }
        char firstLetter = inputString.charAt(0);
        char capitalFirstLetter = Character.toUpperCase(firstLetter);
        return capitalFirstLetter + inputString.substring(1);
    }
}
