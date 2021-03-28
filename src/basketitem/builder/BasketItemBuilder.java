package basketitem.builder;

import basket.BasketItem;
import basket.BasketType;
import product.Product;
import tax.Tax;
import tax.calculator.TaxCalculator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BasketItemBuilder {

    public static BasketItem buildBasketItem(Product product, List<TaxCalculator> calculators, BasketType basketType) {

        Set<Tax> taxList = new HashSet<Tax>();

        for(TaxCalculator calculator : calculators) {

            Tax tax = calculator.calculate(product);
            taxList.add(tax);
        }

        return new BasketItem(product, taxList, basketType);
    }
}
