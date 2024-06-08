package classes;

import java.io.Serial;
import java.io.Serializable;

public class Quest extends AbstractQuest implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public Quest() {
        super();
    }

    public Quest(String name, String brief) {
        super(name, brief);
    }

    @Override
    public void complete() {
        if (!this.getFlag()) this.setFlag();
    }
}
