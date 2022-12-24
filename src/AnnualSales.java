public class AnnualSales {

    int month;
    int year;
    double amount;
    boolean expense;

    public AnnualSales(
        int month,
        int year,
        double amount,
        boolean expense
    ) {
        this.month = month;
        this.year = year;
        this.amount = amount;
        this.expense = expense;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isExpense() {
        return expense;
    }

    @Override
    public String toString() {
        return "AnnualSales{" +
            "month=" + month +
            ", year=" + year +
            ", amount=" + amount +
            ", expense=" + expense +
            '}';
    }
}
