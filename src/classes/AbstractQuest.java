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
        this.name = name;
        this.brief = brief;
    }

    public String getName() {
        return name;
    }

    public String getBrief() {
        return brief;
    }

    public boolean getFlag() {
        return passed;
    }

    public void addBrief(String also) {
        brief += "\n" + also;
    }

    public void setBrief(String newbrief) {
        brief = newbrief;
    }

    public void setFlag() {
        passed = !passed;
    }

    public String getStatus() {
        return passed ? "Выполнено" : "Не выполнено";
    }

    public abstract void complete();
    @Override
    public String toString() {
        return "Задание: " + name + "\nОписание: " + brief + "\nСтатус: " + getStatus();
    }

}
