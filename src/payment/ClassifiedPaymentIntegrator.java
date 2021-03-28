package payment;

import basket.BasketItem;
import basket.BasketType;
import basketitem.collector.BasketItemCollector;
import basketitem.collector.TotalBasketItemFinder;
import money.Money;
import payment.provider.PaymentProvider;
import shoppingchart.ShoppingChart;

import java.util.List;

public class ClassifiedPaymentIntegrator implements PaymentIntegrator{

    private BasketType type;
    private PaymentProvider paymentProvider;

    public ClassifiedPaymentIntegrator(PaymentProvider paymentProvider, BasketType type) {
        this.type = type;
        this.paymentProvider = paymentProvider;
    }

    @Override
    public int makePayment(ShoppingChart shoppingChart) {
        List<BasketItem> items = BasketItemCollector.collectBasketItems(type, shoppingChart);

        Money total = TotalBasketItemFinder.sum(items);

        int chargeId = paymentProvider.charge(total);

        return chargeId;
    }
}
