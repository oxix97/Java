package Generic;

import java.io.Serializable;
public class CastingDTO implements Serializable {
    private Object object;

    public void setObject(Object o) {
        this.object = o;
    }

    public Object getObject() {
        return object;

    }
}
