import classes.Game;

import java.io.*;

public class Serializator {
    public static void main(String[] args) {
        File f = new File("gameMain.dat");
        try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)))) {

            out.writeObject(new Main());

        } catch (IOException ex) {
            System.err.println("ERR not found file");
            ex.printStackTrace();
        }
    }
}
