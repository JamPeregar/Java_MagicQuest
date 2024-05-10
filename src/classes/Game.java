package classes;
import java.util.Scanner;

public class Game {

    private Location start;
    private Location garden;

    //Controls game, catch player commands
    public void game(){

        creationLocations();
        createTransitions();

        Scanner scanner = new Scanner(System.in);

        Location currentLocation = start;//стартовая локация
        System.out.println(currentLocation);
        while (true) {
            System.out.println("Введите команду 'перейти', чтобы выбрать локацию для перехода:");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("перейти")) {//команда для перехода
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
            } else {//остальной ввод
                System.out.println("Неверная команда. Попробуйте снова.");
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

    private static String capitalize(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return inputString;
        }
        char firstLetter = inputString.charAt(0);
        char capitalFirstLetter = Character.toUpperCase(firstLetter);
        return capitalFirstLetter + inputString.substring(1);
    }
}
