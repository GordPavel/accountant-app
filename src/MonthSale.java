public class MonthSale {

    double sumOfOne;
    boolean expense;
    int quantity;
    String itemName;
    int year;
    int month;

    public MonthSale(
        double sumOfOne,
        boolean expense,
        int quantity,
        String itemName,
        int year,
        int month
    ) {
        this.sumOfOne = sumOfOne;
        this.expense = expense;
        this.quantity = quantity;
        this.itemName = itemName;
        this.year = year;
        this.month = month;
    }

    public double getSumOfOne() {
        return sumOfOne;
    }

    public boolean isExpense() {
        return expense;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    @Override
    public String toString() {
        return "MonthSale{" +
            "sumOfOne=" + sumOfOne +
            ", expense=" + expense +
            ", quantity=" + quantity +
            ", itemName='" + itemName + '\'' +
            ", year=" + year +
            ", month=" + month +
            '}';
    }
}
