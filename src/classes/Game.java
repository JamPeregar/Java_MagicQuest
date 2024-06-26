package classes;
import locations.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.Scanner;
import utility.Serializator;

public class Game implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Garden garden = new Garden();
    private Home home = new Home();
    private AtticHomeWizard atticHW = new AtticHomeWizard();
    public AbstractLocation currentLocation = home;
    private Player p1 = Player.createPlayer("Nikita", "Student");
    private static Serializator ser = new Serializator();


    //Controls game, catch player commands
    public void game(){

        {
            //createPlayers();
            createTransitions();
            initializeNPCs();
            //public AbstractLocation currentLocation = home;//стартовая локация
            System.out.println(currentLocation);
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    \nСписок доступных команд:
                    1. перейти - (переход в другую локацию)
                    2. инвентарь - (показывает ваш инвентарь)
                    3. подобрать - (подобрать предмет)
                    4. использовать - (использовать предмет)
                    5. Подойти к НПС
                    6. Сохранить
                    7. Загрузить""");

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
                    System.out.println("Доступные НПС для взаимодействия:");
                    if (!currentLocation.getLocalNPCs().isEmpty()) {
                        for (int i = 0; i < currentLocation.getLocalNPCs().size(); i++) {
                            NonPlayableChar npc = currentLocation.getLocalNPCs().get(i);
                            System.out.println((i + 1) + ". " + npc.getName() + ": " + npc.getDescription());
                        }
                        System.out.println("Введите номер НПС, к которому хотите подойти:");
                        int npcIndex = Integer.parseInt(scanner.nextLine()) - 1;
                        if (npcIndex >= 0 && npcIndex < currentLocation.getLocalNPCs().size()) {
                            NonPlayableChar npc = currentLocation.getLocalNPCs().get(npcIndex);
                            System.out.println("1. Поговорить\n2. Квест");
                            String command2 = scanner.nextLine();
                            switch (capitalize(command2.toLowerCase())){
                                case "1":
                                    npc.speak();
                                    break;
                                case "2":
                                    System.out.println("тут должена быть квестовая система");
                                    break;
                            }
                        } else {
                            System.out.println("Неверный номер НПС.");
                        }
                    } else {
                        System.out.println("В этой локации нет НПС.");
                    }
                    break;

                case "6":
                    saveInv();
                case "7":
                    loadShow();
                case "gs":
                    //ser.saveGame(this);
                //case "exit":
                //    return;



            }

        }
    }

    private void createTransitions (){
        home.addBidirectionalExit("Сад", garden, "Дом волшебника");
        home.addBidirectionalExit("Чердак", atticHW, "Дом волшебника");
    }

    private Player createPlayer(){
        return Player.createPlayer("Nik", "Student");
    }

    public Player getplayer() {return p1;}

    private void initializeNPCs(){
        Entity wizzzrd = new NonPlayableChar();
        Crate woodencrate = new Crate("Деревянный ящик", "Это определённо магическое дерево");
    }

    private static String capitalize(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return inputString;
        }
        char firstLetter = inputString.charAt(0);
        char capitalFirstLetter = Character.toUpperCase(firstLetter);
        return capitalFirstLetter + inputString.substring(1);
    }

    private void saveInv() {
        File f = new File("SAVE1L.dat");
        try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)))) {

            //out.writeObject(this);
            out.writeObject(p1);

        } catch (IOException ex) {
            System.err.println("ERR not found file");
            ex.printStackTrace();
        }
    }

    public void loadShow() {
        try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("SAVE1L.dat")))) {
            this.p1 = (Player) in.readObject();
        }  catch (Exception ex) {ex.printStackTrace();}
        //return null;
    }

}
