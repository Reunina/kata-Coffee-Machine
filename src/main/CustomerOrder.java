package main;

public class CustomerOrder {
    private final char drinkType;
    private final int sugar;
    private final String message;
    private double price;

    public CustomerOrder(char drinkType, int sugar, String message) {
        this.drinkType = drinkType;
        this.sugar = sugar;
        this.message = message;
    }

    public CustomerOrder(char drinkType) {
        this(drinkType, 0, "");
    }

    public CustomerOrder(char drinkType, int sugar) {
        this(drinkType, sugar, "");
    }

    public CustomerOrder(String message) {
        this('T', 0, message);
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

    public String getMessage() {
        return "M:" + message;
    }

    @Override
    public String toString() {
        String order = drinkType + ":";
        if (isStickAdded()) {
            order += sugar + ":0";
        } else order += ":";
        return order;
    }

    public double getPrice() {

        switch (drinkType) {
            case 'T':
                price = 0.4;
                break;
            case 'C':
                price = 0.6;
                break;
            case 'H':
                price = 0.5;
                break;
        }
        return price;
    }
}
