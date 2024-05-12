package classes;

public abstract class AbstractQuest {
    protected String name;
    protected String brief;
    protected boolean passed = false;

    public AbstractQuest() {
        this.name = "Default";
        this.brief = "Default quest";
    }

    public AbstractQuest(final String name, String brief) {
        this.name = "Default";
        this.brief = "Default quest";
    }

    public abstract void complete();

}
