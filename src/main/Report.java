package main;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Report {
    private final Path reportPath;

    public Report(String reportPath) {
        this.reportPath = Paths.get(reportPath);

    }

    public double print_money_earned() {
        return 0.0;
    }

    public String print_sold_drinks() {
        return "";
    }
}
