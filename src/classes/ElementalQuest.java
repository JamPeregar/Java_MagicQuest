package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ElementalQuest extends AbstractQuest{
    private ArrayList<AbstractItem> questitems = new ArrayList<>();

    public ElementalQuest() {
        super();
        //this.questitems = questitems;
    }

    public ElementalQuest(final String name, String brief) {
        super(name, brief);
        //this.questitems = questitems;
    }

    public ElementalQuest(final String name, String brief, ArrayList<AbstractItem> questitems) {
        super(name, brief);
        this.questitems = questitems;
    }

    public void addquestitem(AbstractItem[] items) {
        for (AbstractItem item : items) {
            this.questitems.add(item);
        }
    }

    public void takeItem(String itemName) {
        final Iterator iterator = this.questitems.iterator();
        while (iterator.hasNext()) {
            AbstractItem item = (AbstractItem) iterator.next();
            if (itemName.compareTo(item.getName()) == 0) { // Если нашли нужный предмет
                iterator.remove(); // Удаляем его из списка предметов
                break;
            }
        }
    }

    public boolean questcheck(Entity entity) {
        int itemnum = this.questitems.size();
        int itemcount = 0;
        for(int i = 0; i<itemnum; i++) {
            String questitem = this.questitems.get(i).getName();
            for(AbstractItem item : entity.inventory) {
                if (questitem.compareTo(item.getName()) == 0) {
                    itemcount++;
                }
            }
        }
        if (itemnum <= itemcount) {
            this.complete();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void complete() {
        if (!this.getFlag()) {
            this.setFlag();
            System.out.println("Задание '" + this.getName() + "' выполнено!");
        }
    }
}
