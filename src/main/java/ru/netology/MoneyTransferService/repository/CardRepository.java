package ru.netology.MoneyTransferService.repository;

import org.springframework.stereotype.Repository;
import ru.netology.MoneyTransferService.exception.ErrorInputData;
import ru.netology.MoneyTransferService.model.Card;
import ru.netology.MoneyTransferService.transaction.TransferPost;

import java.text.ParseException;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CardRepository {

    private static final ConcurrentHashMap<String, Card> cards = new ConcurrentHashMap<>();

    public CardRepository() {
        init();
    }

    public static void addCards(Card card) {
        cards.put(card.getNumber(), card);
    }

    public void init() {
        try {
            Card card1 = new Card("2345678912345678",
                    "05/23",
                    "555",
                    "RUB",
                    1000L);
            Card card2 = new Card("9876543212346789",
                    "09/22",
                    "444",
                    "RUB",
                    2000L);
            Card card3 = new Card("1234000099998888",
                    "01/22",
                    "666",
                    "RUB",
                    5000L);
            addCards(card1);
            addCards(card2);
            addCards(card3);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Card getCardByNumber(String cardNumber) {
        if (!cards.containsKey(cardNumber)) {
            throw new ErrorInputData("Card number is not valid");
        }
        return cards.get(cardNumber);
    }
}
