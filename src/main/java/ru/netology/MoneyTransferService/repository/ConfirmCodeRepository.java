package ru.netology.MoneyTransferService.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Repository
public class ConfirmCodeRepository {
    private final Map<String, String> confirmCodeMap = new HashMap<>();

    public void addConfirmation(String idOperation) {
        confirmCodeMap.put(idOperation, getNewCode());
    }

    private String getNewCode() {
        Random random = new Random();
        int rage = 9999;
        int generator = 1000 + random.nextInt(rage - 1000);
        return String.valueOf(generator);
    }

    public String getConfirmationCodeByOperationId(String operationId) {
        return confirmCodeMap.get(operationId);
    }
}

