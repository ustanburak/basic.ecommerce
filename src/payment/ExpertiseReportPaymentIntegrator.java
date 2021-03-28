package payment;

import basket.BasketItem;
import basket.BasketType;
import basketitem.collector.BasketItemCollector;
import basketitem.collector.TotalBasketItemFinder;
import money.Money;
import payment.provider.PaymentProvider;
import shoppingchart.ShoppingChart;

import java.util.List;

public class ExpertiseReportPaymentIntegrator implements PaymentIntegrator{

    private BasketType type;
    private PaymentProvider paymentProvider;

    public ExpertiseReportPaymentIntegrator(BasketType type, PaymentProvider paymentProvider) {
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
