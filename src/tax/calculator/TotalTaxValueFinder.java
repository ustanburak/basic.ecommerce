package tax.calculator;

import money.Currency;
import money.Money;
import tax.Tax;

import java.util.Set;

public class TotalTaxValueFinder {

    public static Money sum(Set<Tax> taxes){
        double totalPriceAsDouble=0;
        Currency currency= null;

        for(Tax tax:taxes){
            if(currency==null){
                currency=tax.getTaxValue().getCurrency();
            }
            Money taxValue= tax.getTaxValue();
        }
        return new Money(totalPriceAsDouble, currency);
    }
}
