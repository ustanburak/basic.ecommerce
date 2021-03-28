package tax.calculator;

import product.Product;
import tax.Tax;

public interface TaxCalculator {

    public Tax calculate(Product product);

}
