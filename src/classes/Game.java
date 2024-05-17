package classes;
import java.util.Scanner;

public class Game {

    private Location start;
    private Location garden;
    private Player p1;
    private Player p2;

    //Controls game, catch player commands
    public void game(){

        createPlayers();
        creationLocations();
        createTransitions();
        createItems();

        Scanner scanner = new Scanner(System.in);

        Location currentLocation = start;//стартовая локация
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
                    System.out.println("Доступные локации для перехода:");
                    for (String direction : currentLocation.getExits().keySet()) {
                        System.out.println(direction);
                    }
                    System.out.println("Введите название локации для перехода:");
                    String chosenLocation = capitalize(scanner.nextLine().toLowerCase());
                    Location nextLocation = currentLocation.go(chosenLocation);
                    if (nextLocation != null) {
                        currentLocation = nextLocation;
                        System.out.println("Вы прибыли в " + currentLocation.getName());
                        System.out.println(currentLocation.getDescription());
                    } else {
                        System.out.println("Неверное название локации.");
                    }

                    break;
                case "2":
                case "Инвентарь":
                    p1.showInventory();
                    break;
                case "3":
                case "Подобрать":
                    System.out.println("Доступные предметы для подбора:");
                    for (AbstractItem item : currentLocation.getLocalInventory()) {
                        System.out.println(item.getName());
                    }
                    System.out.println("Введите название предмета, который хотите подобрать:");
                    String itemName = capitalize(scanner.nextLine().toLowerCase());
                    AbstractItem pickedItem = currentLocation.takeItem(itemName);
                    if (pickedItem != null) {
                        p1.giveItem(pickedItem);
                        System.out.println("Вы подобрали: " + pickedItem.getName());
                    } else {
                        System.out.println("Такого предмета нет в локации.");
                    }
                    break;

                case "4":
                case "Использовать":
                    // Код для использования предмета
                    p1.showInventory();
                    System.out.println("Введите название предмета, который хотите использовать:");
                    String itemNameToUse = capitalize(scanner.nextLine().toLowerCase());
                    p1.useItem(itemNameToUse);
                    break;

            }

        }
    }
    private void creationLocations (){
        start = new Location("Начальная локация", "Вы находитесь в начальной точке");
        garden = new Location("Сад",
                "Вы находитесь в уютном саду, окруженном цветущими растениями и ароматными цветами. Птицы щебечут на деревьях, а солнечные лучи проникают сквозь листву, создавая игривые тени на земле");

    }

    private void createTransitions (){
        start.addExit("Сад", garden);
        garden.addExit("Начальная локация", start);
    }

    private void createItems (){
        AbstractItem potion = new Potion("Странное зелье", "Загадочный напиток, горький запах", "Проклятие поноса!");
        AbstractItem water = new Water("Пузырёк воды", "H2o или просто вода, не забывайте увлажнять организм!", "Получен заряд бодрости");
        AbstractItem water2 = new Water("Целебное зелье воды", "H2o или просто вода, не забывайте увлажнять организм!", "Здоровье восстановлено");
        start.addItem(potion);
        garden.addItem(water);
        start.addItem(water2);
    }

    private void createPlayers(){
        p1 = Player.createPlayer("Nik", "Student");
        p2 = Player.createPlayer("Rin", "Student");
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
