package utility;

import classes.Game;

import java.io.*;

public class Serializator implements Serializable{
    //private static Game game;
    private static final long serialVersionUID = 1L;

    public Serializator() {
        //this.game = g;

    }
    public void saveGame(final Game g) {

        File f = new File("SAVE1L.dat");
        try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)))) {

            out.writeObject(g);

        } catch (IOException ex) {
            System.err.println("ERR not found file");
            ex.printStackTrace();
        }
    }

    public Game loadGame() {
        try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("gameMain.ser")))) {

            FileInputStream fileInputStream = new FileInputStream("gameMain.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            return (Game) objectInputStream.readObject();
        }  catch (Exception ex) {ex.printStackTrace();}
        return null;
    }
}
