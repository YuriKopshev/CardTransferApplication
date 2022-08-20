package ru.netology.MoneyTransferService.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Repository
public class ConfirmCodeRepository {
    private final Map<String, String> confirmCodeMap = new HashMap<>();

    public void addConfirmation(String idOperation) {
        confirmCodeMap.put(idOperation, "0000");
    }

    public String getConfirmationCodeByOperationId(String operationId) {
        return confirmCodeMap.get(operationId);
    }
}

