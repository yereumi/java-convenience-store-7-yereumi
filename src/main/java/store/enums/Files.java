package store.enums;

public enum Files {
    PRODUCTS_FILE_PATH("src/main/resources/products.md"),
    PROMOTIONS_FILE_PATH("src/main/resources/promotions.md");

    private final String value;

    Files(String value) {
        this.value = value;
    }

    public String getValue(Object... args) {
        return String.format(value, args);
    }
}
