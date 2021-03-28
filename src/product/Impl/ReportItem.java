package product.Impl;
import money.Money;
import product.Product;

public class ReportItem implements Product {

    private String name;
    private Money price;

    public ReportItem(String name, Money price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Money getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "ReportItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
