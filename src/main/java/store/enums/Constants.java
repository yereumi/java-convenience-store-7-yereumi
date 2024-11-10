package store.enums;

public enum Constants {
    ZERO(0);

    private final int intValue;

    Constants(int intValue) {
        this.intValue = intValue;
    }

    public int getIntValue() {
        return intValue;
    }
}
