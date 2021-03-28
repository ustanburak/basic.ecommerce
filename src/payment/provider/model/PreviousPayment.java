package payment.provider.model;

import money.Money;

import java.util.Date;

public class PreviousPayment {
    private Money value;
    private Date recordDate;

    public PreviousPayment(Money value, Date recordDate) {
        this.value = value;
        this.recordDate = recordDate;
    }

    public Money getValue() {
        return value;
    }

    public void setValue(Money value) {
        this.value = value;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    @Override
    public String toString() {
        return "PreviousPayment [value=" + value + ", recordDate=" + recordDate + "]";
    }

}
