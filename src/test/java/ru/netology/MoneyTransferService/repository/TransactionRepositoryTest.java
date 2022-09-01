package ru.netology.MoneyTransferService.repository;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.MoneyTransferService.transaction.TransferPost;

import static org.junit.jupiter.api.Assertions.*;

class TransactionRepositoryTest {

    private final TransactionRepository repository = new TransactionRepository();
    private final TransferPost transferPost = new TransferPost();

    @Test
    void getIdOperation() {
        assertEquals("1", repository.getIdOperation());
    }

    @Test
    void addTransaction() {
        assertEquals("1", repository.addTransaction(transferPost));
    }

    @Test
    void getTransactionById() {
        String operationId = "1";
        repository.addTransaction(transferPost);
        assertEquals(transferPost, repository.getTransactionById(operationId));
    }
}