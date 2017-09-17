package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Report {
    private final Path reportPath;
    private Map<String, Integer> soldDrinks = new HashMap<>();

    public Report(String reportPath) {
        this.reportPath = Paths.get(reportPath);

    }

    public double print_money_earned() {
        double moneyEarned = 0.0;

        try {
            moneyEarned = Files.lines(reportPath)
                    .mapToDouble(this::getProfit)
                    .sum();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return moneyEarned;
    }

    private double getProfit(String l) {
        String[] values = l.split(" ");
        return Double.valueOf(values[values.length - 1]);
    }

    public String print_sold_drinks() {
        soldDrinks = new HashMap<>();
        try {
            Files.lines(reportPath)
                    .map(this::getDrink)
                    .forEach(this::addDrink);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return soldDrinks.entrySet()
                .stream()
                .map(entry -> entry.getKey() + ":" + entry.getValue())
                .collect(Collectors.joining(" "));
    }

    private void addDrink(String drink) {
        if (soldDrinks.containsKey(drink)) {
            int newCount = soldDrinks.get(drink) + 1;
            soldDrinks.remove(drink);
            soldDrinks.put(drink, newCount);
        } else {
            soldDrinks.put(drink, 1);
        }

    }

    private String getDrink(String l) {
        return l.split(":")[0];
    }
}
