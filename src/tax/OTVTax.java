package tax;

import money.Money;

public class OTVTax implements  Tax {

    private String name;
    private Money price;

    public OTVTax(String name, Money price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Money getTaxValue() {
        return this.price;
    }

    @Override
    public String toString() {
        return "OTVTax{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
