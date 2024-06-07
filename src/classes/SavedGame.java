package classes;

import java.io.Serializable;
import java.util.ArrayList;

public class SavedGame implements Serializable {
    private ArrayList<AbstractItem> saveInventory;
    public SavedGame(ArrayList<AbstractItem> saveInventory){
        this.saveInventory = saveInventory;
    }
}
