package classes;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class NonPlayableChar extends Entity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private ArrayList<String> quotelist = new ArrayList<>();

    public NonPlayableChar() {
        super();
        this.quotelist.add("Привет, я персонаж по умолчанию и фразы пишу соответствующие.");
        this.quotelist.add("Ты не настроил меня!");
        this.quotelist.add("По крайне мере не льёт как из ведра.");
    }

    public NonPlayableChar(String name, String descr) {
        super(name, descr);
        this.quotelist.add("Привет, я персонаж по умолчанию и фразы пишу соответствующие.");
        this.quotelist.add("Ты не настроил меня!");
        this.quotelist.add("По крайне мере, не льёт как из ведра.");
    }

    public NonPlayableChar(String name, String descr, ArrayList quotes) {
        super(name, descr);
        this.quotelist = quotes;
    }

    public void speak() {
        if (this.isAlive()) {
            System.out.println(this.getName() + ": " + this.quotelist.get(getLocalRandom(this.quotelist.size())));
        } else  {
            System.out.println(this.getName() + ": " + "bro, im dead");
        }
    }

    public void passQuest(AbstractItem[] items) {

    }

    private static int getLocalRandom(int seed) {
        return (int) (Math.random() * seed);
    }
    public String getDescription() {
        return this.getDescr();
    }

}
