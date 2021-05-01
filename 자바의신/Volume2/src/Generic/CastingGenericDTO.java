package Generic;

import java.io.Serializable;

public class CastingGenericDTO<T> implements Serializable {
    private T object;

    public void setObject(T o) {
        this.object = o;
    }

    public T getObject() {
        return object;

    }
}
