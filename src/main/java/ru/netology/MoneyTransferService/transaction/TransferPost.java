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
            Amount amount) {
        this.cardFromNumber = cardFromNumber;
        this.cardFromValidTill = cardFromValidTill;
        this.cardFromCVV = cardFromCVV;
        this.cardToNumber = cardToNumber;
        this.amount = amount;
    }

    public String getCardFromNumber() {
        return cardFromNumber;
    }

    public String getCardToNumber() {
        return cardToNumber;
    }

    public long getAmountValue() {
        return amount.getValue();
    }

    public String getCardFromValidTill() {
        return cardFromValidTill;
    }

    public String getCardFromCVV() {
        return cardFromCVV;
    }

    @Override
    public String toString() {
        return "TransferPost{" +
                "cardFromNumber='" + cardFromNumber + '\'' +
                ", cardFromValidTill='" + cardFromValidTill + '\'' +
                ", cardFromCVV='" + cardFromCVV + '\'' +
                ", cardToNumber='" + cardToNumber + '\'' +
                ", amount=" + amount +
                '}';
    }
}


