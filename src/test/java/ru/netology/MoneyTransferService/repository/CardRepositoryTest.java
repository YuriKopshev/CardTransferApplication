package ru.netology.MoneyTransferService.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import ru.netology.MoneyTransferService.model.Card;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CardRepositoryTest {
    private final Card testCard;
    private CardRepository cardRepository;

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

    @BeforeEach
    void beforeEach() {
        cardRepository = new CardRepository();
    }

    @Test
    void addCardsTest() {
        CardRepository.addCards(testCard);
        Card actualCard = cardRepository.getCardByNumber("1111111111111111");
        assertEquals("1111111111111111", actualCard.getNumber());
    }

    @Test
    void GetCardByNumberTest() {
        Card card = cardRepository.getCardByNumber("1234000099998888");
        assertEquals("1234000099998888", card.getNumber());
    }

    @Test
    void notValidGetCardByNumberTest() {
        assertThrows(RuntimeException.class, () -> cardRepository.getCardByNumber("000234000099998888"));
    }
}