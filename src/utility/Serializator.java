package utility;

import classes.Game;
import classes.Game2;

import java.io.*;

public class Serializator implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;
    private Game2 game;
    //private static Game game;

    public Serializator() {
        //this.game = g;

    }
    public void saveGame(final Game2 g) {

        File f = new File("GSAVE.dat");
        try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)))) {
            game = g;
            out.writeObject(game);
            //out.writeObject(g.getplayer());

        } catch (IOException ex) {
            System.err.println("ERR not found file");
            ex.printStackTrace();
        }
    }

    public Game2 loadGame() {
        try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("GSAVE.dat")))) {
            game = (Game2)in.readObject();
            //return (Game) objectInputStream.readObject();
            //return (Game)in.readObject();
            return game;
        }  catch (Exception ex) {ex.printStackTrace();}
        return new Game2();
    }
}
