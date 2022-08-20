package ru.netology.MoneyTransferService.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransferPost {
    private String cardFromNumber;

    private String cardFromValidTill;

    private String cardFromCVV;

    private String cardToNumber;

    private Amount amount;

    public TransferPost() {
    }

    public TransferPost(
        @JsonProperty("cardFromNumber")
        String cardFromNumber,
        @JsonProperty("cardFromValidTill")
        String cardFromValidTill,
        @JsonProperty("cardFromCVV")
        String cardFromCVV,
        @JsonProperty("cardToNumber")
        String cardToNumber,
        @JsonProperty("amount")
        Amount amount){
        this.cardFromNumber = cardFromNumber;
        this.cardFromValidTill = cardFromValidTill;
        this.cardFromCVV = cardFromCVV;
        this.cardToNumber = cardToNumber;
        this.amount = amount;
    }

    public String getCardFromNumber() {
        return cardFromNumber;
    }

    public void setCardFromNumber(String cardFromNumber) {
        this.cardFromNumber = cardFromNumber;
    }

    public String getCardFromValidTill() {
        return cardFromValidTill;
    }

    public void setCardFromValidTill(String cardFromValidTill) {
        this.cardFromValidTill = cardFromValidTill;
    }

    public String getCardFromCVV() {
        return cardFromCVV;
    }

    public void setCardFromCVV(String cardFromCVV) {
        this.cardFromCVV = cardFromCVV;
    }

    public String getCardToNumber() {
        return cardToNumber;
    }

    public void setCardToNumber(String cardToNumber) {
        this.cardToNumber = cardToNumber;
    }

    public long getAmountValue() {
        return amount.getValue();
    }
}


