import classes.*;
import utility.Serializator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        String cmd;

        Game game = new Game();
        Serializator ser = new Serializator();
        game.game();
        while (true) {
            cmd = in.next();
            if (cmd.equalsIgnoreCase("1")) {
                ser.saveGame(game);
            }
            else {
                game = ser.loadGame();
            }
        }

    }
}