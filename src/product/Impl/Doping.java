package product.Impl;

import money.Money;
import product.Impl.type.DopingType;
import product.Product;

public class Doping implements Product {

    private String name;
    private Money price;
    private DopingType type;

    public Doping(String name, Money price, DopingType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Money getPrice() {
        return null;
    }
}
