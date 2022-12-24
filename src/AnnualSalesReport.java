import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class AnnualSalesReport {

    private ArrayList<AnnualSales> sales;

    public AnnualSalesReport() {
        sales = new ArrayList<>();
    }

    public AnnualSalesReport(ArrayList<AnnualSales> sales) {
        this.sales = sales;
    }

    void readAnnualReport(String file) throws IOException {
        final var yearString = Paths.get(file).getFileName().toString().split("\\.")[1];
        final var year = Integer.parseInt(yearString);
        final var lines = Files.readAllLines(Paths.get(file));
        for (int i = 1; i < lines.size(); i++) {
            final var lineParts = lines.get(i).split(",");
            final var month = Integer.parseInt(lineParts[0]);
            final var amount = Double.parseDouble(lineParts[1]);
            final var expense = Boolean.parseBoolean(lineParts[2]);
            final var annualSale = new AnnualSales(
                month,
                year,
                amount,
                expense
            );
            sales.add(annualSale);
        }
    }

    void compareWithAnotherAnnualReport(AnnualSalesReport other) {
        final ArrayList<AnnualSales> thisSales = sales;
        final ArrayList<AnnualSales> otherSales = other.sales;
        if (thisSales.size() != otherSales.size()) {
            System.out.println("Отчеты не равны – разные размеры данных");
            return;
        }
        for (int i = 0; i < thisSales.size(); i++) {
            final AnnualSales thisSale = thisSales.get(i);
            final AnnualSales otherSale = otherSales.get(i);
            if (thisSale.expense != otherSale.expense) {
                System.out.println("Отчеты не равны – не сходится статистика за " + thisSale.month + " месяц");
                return;
            }
            if (thisSale.amount != otherSale.amount) {
                System.out.println("Отчеты не равны – не сходится статистика за " + thisSale.month + " месяц");
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "AnnualSalesReport{" +
            "sales=" + Arrays.toString(sales.toArray()) +
            '}';
    }
}
