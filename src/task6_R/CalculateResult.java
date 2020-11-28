package task6_R;

public class CalculateResult {
    private final int quantity;
    private final double sum;

    public CalculateResult(int quantity, double sum) {
        this.quantity = quantity;
        this.sum = sum;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSum() {
        return sum;
    }
}
