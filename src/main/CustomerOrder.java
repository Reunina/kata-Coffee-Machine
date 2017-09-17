package main;

public class CustomerOrder {
    private final String drinkType;
    private final int sugar;

    public CustomerOrder(String drinkType, int sugar) {
        this.drinkType = drinkType;
        this.sugar = sugar;
    }

    public CustomerOrder(String drinkType) {
        this(drinkType, 0);
    }

    public String getDrinkType() {
        return drinkType;
    }

    public int getSugar() {
        return sugar;
    }

    public boolean isStickAdded() {
        return sugar != 0 && sugar > 0;
    }
}
