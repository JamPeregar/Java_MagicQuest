package locations;
import classes.*;

import java.io.Serializable;

public class AtticHomeWizard extends AbstractLocation implements Serializable {

    public AtticHomeWizard() {
        super("Чердак", "Вы находитесь на пыльном чердаке дома волшебника. Повсюду разбросаны старые книги, паутина свисает с углов, а на полках лежат загадочные предметы.");
        initializeItems();
        initializeNPCs();
        initializeObjects();
    }

    @Override
    public void initializeItems() {
        AbstractItem poison = new Poison("Яд", "Загадочный напиток, горький запах", "Отравление");
    }

    @Override
    public void initializeNPCs() {

    }

    @Override
    public void initializeObjects(){
        Crate crate = new Crate("Ящик", "Старый деревянный ящик. Интересно, что внутри?"){
            @Override
            public void interract(Entity interractor) {
                AbstractItem item = new Poison();
                interractor.giveItem(item);
                System.out.println("В ящике найдено: " + item.getName());
            }
        };
        this.addObject(crate);
    }
}
