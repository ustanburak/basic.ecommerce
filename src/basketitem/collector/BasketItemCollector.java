package basketitem.collector;

import basket.BasketItem;
import basket.BasketType;
import shoppingchart.ShoppingChart;

import java.util.ArrayList;
import java.util.List;

public class BasketItemCollector {
    public static List<BasketItem> collectBasketItems(BasketType type, ShoppingChart shoppingChart) {

        List<BasketItem> basketItems = new ArrayList<BasketItem>();

        for(BasketItem item : shoppingChart.getBasketItemList()) {

            if(type.equals(item.getType())) {
                basketItems.add(item);
            }
        }

        return basketItems;
    }
}
