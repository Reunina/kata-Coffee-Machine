package main;

public class CustomerOrder {
    private final char drinkType;
    private final int sugar;
    private final String message;
    private double inputMoney;

    public CustomerOrder(char drinkType, int sugar, String message, double inputMoneys) {
        this.drinkType = drinkType;
        this.sugar = sugar;
        this.message = message;
        this.inputMoney = inputMoneys;
    }

    public CustomerOrder(char drinkType) {
        this(drinkType, 0, "", 0.0);
    }

    public CustomerOrder(char drinkType, int sugar) {
        this(drinkType, sugar, "", 0.0);
    }

    public CustomerOrder(char drinkType, double inputMoney) {
        this(drinkType, 0, "", inputMoney);
    }

    public CustomerOrder(String message) {
        this('T', 0, message, 0.0);
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
        double price = 0.0;
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

    public boolean makeTheDrink(){
        return inputMoney >= getPrice();

    }

    public String getMessageForDrinkMaker(){
        if(makeTheDrink()){
            return  "Ok , make the drink";
        }else {
            double missingMoney = getPrice() - inputMoney;
            return  "Ko , do not make the drink. "+ missingMoney+" euros are missing";
        }
    }
}
