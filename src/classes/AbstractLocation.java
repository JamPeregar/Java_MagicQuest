package classes;

public class AbstractLocation {
    private final String name;
    private final String descr;
    private String[] paths;

    public AbstractLocation(final String name, final String dscr, String[] paths) {
        this.name = name;
        this.descr = dscr;
    }



    @Override
    public String toString() {
        return "\n" + this.name + " теперь зона вашего прибывания.\n"
                + "Характеристика места: " + this.descr;
    }

}
