package ru.netology.MoneyTransferService.repository;

import org.springframework.stereotype.Repository;
import ru.netology.MoneyTransferService.exception.ErrorConfirmation;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ConfirmCodeRepository {
    private final ConcurrentHashMap<String, String> confirmCodeMap = new ConcurrentHashMap<>();

    public void addConfirmation(String idOperation) {
        confirmCodeMap.put(idOperation, "0000");
    }

    public String getIdByCodeValue(String code) {
        Set<Map.Entry<String, String>> entrySet = confirmCodeMap.entrySet();
        for (Map.Entry<String, String> pair : entrySet) {
            if (code.equals(pair.getValue())) {
                return pair.getKey();// нашли наше значение и возвращаем  ключ
            }
        }
        throw new ErrorConfirmation("Confirmation code is not valid");
    }

    public ConcurrentHashMap<String, String> getConfirmCodeMap() {
        return confirmCodeMap;
    }
}

