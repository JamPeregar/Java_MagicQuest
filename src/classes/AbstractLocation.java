package classes;

public class AbstractLocation {
    private final String name;
    private final String descr;
    //private String[] paths;

    public AbstractLocation(final String name, final String dscr, String[] paths) {
        this.name = name;
        this.descr = dscr;
    }
    public AbstractLocation(final String name, final String dscr) {
        this.name = name;
        this.descr = dscr;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return descr;
    }



    @Override
    public String toString() {
        return "\n" + this.name + " теперь зона вашего прибывания.\n"
                + "Характеристика места: " + this.descr;
    }

}
