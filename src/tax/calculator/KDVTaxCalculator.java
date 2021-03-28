package tax.calculator;

import money.Money;
import product.Product;
import tax.KDVTax;
import tax.Tax;

public class KDVTaxCalculator implements TaxCalculator {
    @Override
    public Tax calculate(Product product) {

        Money price= product.getPrice();
        double taxValue=price.getValue()*0.88;

        return new KDVTax("KDV", new Money(taxValue,price.getCurrency()));
    }
}
