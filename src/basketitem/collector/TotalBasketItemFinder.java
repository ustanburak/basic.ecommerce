package basketitem.collector;

import basket.BasketItem;
import money.Currency;
import money.Money;
import money.MoneyCalculator;
import tax.calculator.TotalTaxValueFinder;

import java.util.List;

public class TotalBasketItemFinder {

    public static Money sum(List<BasketItem> items) {

        double totalValue = 0;
        Currency currency = null;

        for(BasketItem item : items) {

            Money productPrice = item.getProduct().getPrice();
            Money taxMoney = TotalTaxValueFinder.sum(item.getTaxList());
            Money total = MoneyCalculator.sum(productPrice, taxMoney);

            if(currency == null && total != null) {
                currency = total.getCurrency();
            }

            if(total != null) {
                totalValue += total.getValue();
            }
        }

        return new Money(totalValue, currency);
    }
}
