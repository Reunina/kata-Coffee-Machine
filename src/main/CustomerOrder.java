package main;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class CustomerOrder {
    private final char drinkType;
    private final int sugar;
    private final String message;
    private double inputMoney;
    private boolean isExtraHot;

    public CustomerOrder(char drinkType, int sugar, String message, double inputMoneys, boolean isExtraHot) {
        this.drinkType = drinkType;
        this.sugar = sugar;
        this.message = message;
        this.inputMoney = inputMoneys;
        this.isExtraHot = isExtraHot;
    }

    public CustomerOrder(char drinkType) {
        this(drinkType, 0, "", 0.0, false);
    }

    public CustomerOrder(char drinkType, int sugar) {
        this(drinkType, sugar, "", 0.0, false);
    }

    public CustomerOrder(char drinkType, int sugar, double inputMoney) {
        this(drinkType, sugar, "", inputMoney, false);
    }

    public CustomerOrder(char drinkType, double inputMoney) {
        this(drinkType, 0, "", inputMoney, false);
    }

    public CustomerOrder(String message) {
        this('T', 0, message, 0.0, false);
    }

    public CustomerOrder(char drinkType, boolean isExtraHot) {
        this(drinkType, 0, "", 0.0, isExtraHot);
    }

    public CustomerOrder(char drinkType, boolean isExtraHot, int sugar) {
        this(drinkType, sugar, "", 0.0, isExtraHot);
    }

    public CustomerOrder(char drinkType, boolean isExtraHot, int sugar, double inputMoney) {
        this(drinkType, sugar, "", 0.0, isExtraHot);
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
        String order;
        if (isExtraHot) {
            order = drinkType + "h" + ":";
        } else {
            order = drinkType + ":";
        }
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
            case 'O':
                price = 0.6;
                break;
        }
        return price;
    }

    public boolean makeTheDrink() {

        boolean isTheDrinkMade = inputMoney >= getPrice();
        report(this, inputMoney, getPrice(), isTheDrinkMade);
        return isTheDrinkMade;

    }

    public String getMessageForDrinkMaker() {
        if (makeTheDrink()) {
            return "Ok , make the drink";
        } else {
            double missingMoney = getPrice() - inputMoney;
            return "Ko , do not make the drink. " + missingMoney + " euros are missing";
        }
    }

    private void report(CustomerOrder order, double inputMoney, double price, boolean isTheDrinkMade) {
        String reportPath = "src/test/resources/dataReport/data_report.txt";

        double profit = isTheDrinkMade ? price : 0.0;
        String lineToReport = order.toString() + " " + inputMoney + " " + price + " " + profit + "\n";
        try {
            Files.write(Paths.get(reportPath), lineToReport.getBytes(), StandardOpenOption.APPEND);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
