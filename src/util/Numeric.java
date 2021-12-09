package util;

/**
 * @author Fulkin
 * Created on 09.12.2021
 */

public class Numeric {
    private final int value;
    private final TypeNumber type;

    public Numeric(int value, TypeNumber type) {
        this.value = value;
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public TypeNumber getType() {
        return type;
    }
}
