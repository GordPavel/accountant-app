import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MonthSalesReport {

    private ArrayList<MonthSale> monthSales;

    public MonthSalesReport() {
        this.monthSales = new ArrayList<>();
    }

    void readAllMonthReports(int year) throws IOException {
        for (int i = 0; i < 3; i++) {
            readMonthReport(year, i);
        }
    }

    void readMonthReport(int year, int month) throws IOException {
        readMonthReport(("m." + year) + String.format("%02d", month) + ".csv");
    }

    void readMonthReport(String file) throws IOException {
        final var yearMonth = Paths.get(file).getFileName().toString().split("\\.")[1];
        final var year = Integer.parseInt(yearMonth.substring(0, 4));
        final var month = Integer.parseInt(yearMonth.substring(4));
        final List<String> lines = Files.readAllLines(Paths.get(file));
        for (int i = 1; i < lines.size(); i++) {
            final var parts = lines.get(i).split(",");
            monthSales.add(new MonthSale(
                Double.parseDouble(parts[3]),
                "TRUE".equals(parts[1]),
                Integer.parseInt(parts[2]),
                parts[0],
                year,
                month
            ));
        }
    }

    void printMonthStats(int year, int month) {
        for (int i = 0; i < monthSales.size(); i++) {
            final var sale = monthSales.get(i);
            if (sale.year == year && sale.month == month) {
                System.out.println(sale.sumOfOne + " " + sale.quantity + " " + sale.expense);
            }
        }
    }

    void printAllMonthesStats() {
        for (int i = 0; i < monthSales.size(); i++) {
            final var sale = monthSales.get(i);
            System.out.println(sale.sumOfOne + " " + sale.quantity + " " + sale.expense);
        }
    }

    public AnnualSalesReport calculateAnnualReport() {
        final HashMap<String, AnnualSales> monthStats = new HashMap<>();
        for (int i = 0; i < monthSales.size(); i++) {
            final MonthSale sale = monthSales.get(i);
            final String key = sale.month + "-" + sale.expense;
            AnnualSales existingStats = monthStats.get(key);
            if (existingStats == null) {
                existingStats = new AnnualSales(
                    sale.month,
                    sale.year,
                    sale.quantity * sale.sumOfOne,
                    sale.expense
                );
            } else {
                existingStats = new AnnualSales(
                    sale.month,
                    sale.year,
                    existingStats.amount + sale.quantity * sale.sumOfOne,
                    sale.expense
                );
            }
            monthStats.put(key, existingStats);
        }

        return new AnnualSalesReport(new ArrayList<>(monthStats.values()));
    }

    @Override
    public String toString() {
        return "MonthSalesReport{" +
            "monthSales=" + Arrays.toString(monthSales.toArray()) +
            '}';
    }
}
