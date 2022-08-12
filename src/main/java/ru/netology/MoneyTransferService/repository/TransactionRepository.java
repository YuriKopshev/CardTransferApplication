package ru.netology.MoneyTransferService.repository;

import org.springframework.stereotype.Repository;
import ru.netology.MoneyTransferService.transaction.TransferPost;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class TransactionRepository {
    private final AtomicInteger counter = new AtomicInteger(1);
    private final Map<String, TransferPost> transferPostMap = new HashMap<>();

    public String getIdOperation() {
        return String.valueOf(counter.getAndIncrement());
    }

    public String addTransaction(TransferPost transferPost) {
        String operationId = getIdOperation();
        transferPostMap.put(operationId, transferPost);
        return operationId;
    }

    public TransferPost getTransactionById(String operationId) {
        return transferPostMap.get(operationId);
    }
}
