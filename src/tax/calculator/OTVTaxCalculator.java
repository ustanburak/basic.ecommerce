package tax.calculator;

import money.Money;
import product.Product;
import tax.OTVTax;
import tax.Tax;

public class OTVTaxCalculator implements TaxCalculator{
    @Override
    public Tax calculate(Product product) {
        Money price = product.getPrice();

        double taxValue = price.getValue() * 0.10;

        return new OTVTax("ÖTV", new Money(taxValue, price.getCurrency()));
    }
}
