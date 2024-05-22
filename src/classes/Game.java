package classes;
import locations.*;
import java.util.Map;
import java.util.List;
import java.util.Scanner;

public class Game {

    private Garden garden;
    private Home home;
    private AtticHomeWizard atticHW;
    private Player p1;
    private Player p2;

    //Controls game, catch player commands
    public void game(){

        createPlayers();
        creationLocations();
        createTransitions ();

        Scanner scanner = new Scanner(System.in);

        AbstractLocation currentLocation = home;//стартовая локация
        System.out.println(currentLocation);
        while (true) {
            System.out.println("""
                    \nСписок доступных команд:
                    1. перейти - (переход в другую локацию)
                    2. инвентарь - (показывает ваш инвентарь)
                    3. подобрать - (подобрать предмет)
                    4. использовать - (использовать предмет)""");

            String command = scanner.nextLine();
            switch (capitalize(command.toLowerCase())){
                case "1":
                case "Перейти":
                    // Отображение доступных локаций с порядковыми номерами
                    System.out.println("Доступные локации для перехода:");
                    int index = 1;
                    Map<String, AbstractLocation> exits = currentLocation.getExits();
                    for (String direction : exits.keySet()) {
                        System.out.println(index + ". " + direction);
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
                    break;
                case "2":
                case "Инвентарь":
                    p1.showInventory();
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
                    break;
                case "5":
                case "Подойти к НПС":


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
        p2 = Player.createPlayer("Rin", "Student");
    }

    private void initializeNPCs(){

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
