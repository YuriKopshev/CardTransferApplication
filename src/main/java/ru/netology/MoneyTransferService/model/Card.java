package ru.netology.MoneyTransferService.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Card {

    private final String number;
    private final Date validTill;
    private final String CVV;
    private final String currency;
    private long balance;

    private final static SimpleDateFormat simpleDateFormatter = new SimpleDateFormat("MM/yy");

    private static Date getDate(String validTill) throws ParseException {
        return simpleDateFormatter.parse(validTill);
    }

    public Card(String number,
                String validTill,
                String CVV,
                String currency,
                long balance) throws ParseException {
        this.number = number;
        this.validTill = getDate(validTill);
        this.CVV = CVV;
        this.currency = currency;
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public Date getValidTill() {
        return validTill;
    }

    public String getCVV() {
        return CVV;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return number.equals(card.number) && validTill.equals(card.validTill) && CVV.equals(card.CVV);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, validTill, CVV);
    }
}