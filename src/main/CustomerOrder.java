package main;

public class CustomerOrder {
    private final char drinkType;
    private final int sugar;
    private final String message;

    public CustomerOrder(char drinkType, int sugar, String message) {
        this.drinkType = drinkType;
        this.sugar = sugar;
        this.message = "";
    }
    public CustomerOrder(char drinkType) {
        this(drinkType, 0, "");
    }

    public CustomerOrder(char drinkType, int sugar) {
        this(drinkType, sugar, "");
    }

    public char getDrinkType() {
        return drinkType;
    }

    public int getSugar() {
        return sugar;
    }

    public boolean isStickAdded() {
        return sugar != 0 && sugar > 0;
    }
}
