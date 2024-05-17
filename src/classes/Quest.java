package classes;

public class Quest extends AbstractQuest{

    public Quest() {
        super();
    }

    public Quest(String name, String brief) {
        super(name, brief);
    }

    @Override
    public void complete() {
        if (this.getFlag()) this.setFlag();
    }
}
