package tax;

import money.Money;

public interface Tax {

    public String getName();
    public Money getTaxValue();
}
