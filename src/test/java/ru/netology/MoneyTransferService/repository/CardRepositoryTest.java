package ru.netology.MoneyTransferService.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import ru.netology.MoneyTransferService.model.Card;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CardRepositoryTest {
    private final Card testCard;

    {
        try {
            testCard = new Card("1111111111111111",
                    "05/25",
                    "111",
                    "RUB",
                    11111L);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void addCardsTest() {
        CardRepository cardRepository = new CardRepository();
        CardRepository.addCards(testCard);
        Card actualCard = cardRepository.getCardByNumber("1111111111111111");
        assertEquals("1111111111111111", actualCard.getNumber());

    }

    @Test
    void GetCardByNumberTest() {
        CardRepository cardRepository = new CardRepository();
        Card card = cardRepository.getCardByNumber("1234000099998888");
        assertEquals("1234000099998888", card.getNumber());
    }

    @Test
    void notValidGetCardByNumberTest() {
        CardRepository cardRepository = new CardRepository();
        assertThrows(RuntimeException.class, () -> cardRepository.getCardByNumber("000234000099998888"));

    }
}