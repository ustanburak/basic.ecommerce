package payment;

import shoppingchart.ShoppingChart;

public interface PaymentIntegrator {
    public int makePayment(ShoppingChart shoppingChart);
}
