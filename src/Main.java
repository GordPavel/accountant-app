import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        final var monthSalesReport = new MonthSalesReport();
        monthSalesReport.readAllMonthReports(2021);
        final var annualSalesReport = new AnnualSalesReport();
        annualSalesReport.readAnnualReport("y.2021.csv");
        final var calculatedAnnualReport = monthSalesReport.calculateAnnualReport();

        System.out.println("Считанный файл");
        System.out.println(annualSalesReport);
        System.out.println("================");
        System.out.println("Посчитанная статистика");
        System.out.println(calculatedAnnualReport);
        System.out.println("================");
    }
}


