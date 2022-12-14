package ru.netology.MoneyTransferService.transaction;

public class Amount {
    private long value;
    private String currency;

    public Amount(long value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public Amount() {
    }

    public long getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
