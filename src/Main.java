import classes.*;
import utility.Serializator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        Serializator ser = new Serializator();
        String cmd;

        System.out.println("Начать новую игру? - 1 да");
        cmd = in.next();
        if (cmd.equalsIgnoreCase("1")) {
            Game2 game = new Game2();
            game.game();
        } else {
            Game2 game = ser.loadGame();
            game.game();
        }
    }

}