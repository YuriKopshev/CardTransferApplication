package ru.netology.MoneyTransferService.service;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import org.mockito.Mockito;
import ru.netology.MoneyTransferService.exception.ErrorConfirmation;
import ru.netology.MoneyTransferService.exception.ErrorInputData;
import ru.netology.MoneyTransferService.exception.ErrorTransferOperation;
import ru.netology.MoneyTransferService.repository.CardRepository;
import ru.netology.MoneyTransferService.repository.ConfirmCodeRepository;
import ru.netology.MoneyTransferService.repository.TransactionRepository;
import ru.netology.MoneyTransferService.transaction.PostConfirm;
import ru.netology.MoneyTransferService.transaction.TransferPost;

import static org.junit.jupiter.api.Assertions.*;

class CardTransferServiceTest {
    private final CardRepository repository = new CardRepository();
    private final TransactionRepository transactionRepository = new TransactionRepository();
    private final ConfirmCodeRepository confirmRepository = new ConfirmCodeRepository();
    private final CardTransferService service = new CardTransferService(repository, transactionRepository, confirmRepository);
    private final TransferPost transferPost = Mockito.mock(TransferPost.class);

    private final PostConfirm confirm = Mockito.mock(PostConfirm.class);

    @Test
    void transferTest() {
        when(transferPost.getCardFromNumber()).thenReturn("9876543212346789");
        when(transferPost.getCardToNumber()).thenReturn("2345678912345678");
        when(transferPost.getCardFromCVV()).thenReturn("444");
        when(transferPost.getCardFromValidTill()).thenReturn("07/23");
        String actualId = service.transfer(transferPost);
        assertEquals("1", actualId);
    }

    @Test
    void wrongCVVTransferTest() {
        when(transferPost.getCardFromNumber()).thenReturn("9876543212346789");
        when(transferPost.getCardToNumber()).thenReturn("2345678912345678");
        when(transferPost.getCardFromCVV()).thenReturn("111");
        when(transferPost.getCardFromValidTill()).thenReturn("07/23");
        assertThrows(ErrorInputData.class, () -> service.transfer(transferPost));

    }

    @Test
    void wrongValidDateTransferTest() {
        when(transferPost.getCardFromNumber()).thenReturn("9876543212346789");
        when(transferPost.getCardToNumber()).thenReturn("2345678912345678");
        when(transferPost.getCardFromCVV()).thenReturn("444");
        when(transferPost.getCardFromValidTill()).thenReturn("07/19");
        assertThrows(ErrorInputData.class, () -> service.transfer(transferPost));

    }

    @Test
    void wrongSumTransferTest() {
        when(transferPost.getCardFromNumber()).thenReturn("9876543212346789");
        when(transferPost.getCardToNumber()).thenReturn("2345678912345678");
        when(transferPost.getCardFromCVV()).thenReturn("444");
        when(transferPost.getCardFromValidTill()).thenReturn("07/23");
        when(transferPost.getAmountValue()).thenReturn(10000000L);
        assertThrows(ErrorTransferOperation.class, () -> service.transfer(transferPost));
    }

    @Test
    void sameCardsTransferTest() {
        when(transferPost.getCardFromNumber()).thenReturn("9876543212346789");
        when(transferPost.getCardToNumber()).thenReturn("9876543212346789");
        when(transferPost.getCardFromCVV()).thenReturn("444");
        when(transferPost.getCardFromValidTill()).thenReturn("07/23");
        assertThrows(ErrorTransferOperation.class, () -> service.transfer(transferPost));
    }

    @Test
    void confirmOperation() {
        when(transferPost.getCardFromNumber()).thenReturn("9876543212346789");
        when(transferPost.getCardToNumber()).thenReturn("2345678912345678");
        when(transferPost.getCardFromCVV()).thenReturn("444");
        when(transferPost.getCardFromValidTill()).thenReturn("07/23");
        service.transfer(transferPost);
        when(confirm.getCode()).thenReturn("0000");
        String expectId = "1";
        String actualId = service.confirmOperation(confirm);
        assertEquals(expectId, actualId);
    }

    @Test
    void wrongConfirmOperation() {
        when(transferPost.getCardFromNumber()).thenReturn("9876543212346789");
        when(transferPost.getCardToNumber()).thenReturn("2345678912345678");
        when(transferPost.getCardFromCVV()).thenReturn("444");
        when(transferPost.getCardFromValidTill()).thenReturn("07/23");
        service.transfer(transferPost);
        when(confirm.getCode()).thenReturn("5555");
        assertThrows(ErrorConfirmation.class, () -> service.confirmOperation(confirm));
    }
}