package ru.netology.MoneyTransferService.repository;

import org.junit.jupiter.api.Test;
import ru.netology.MoneyTransferService.exception.ErrorConfirmation;

import static org.junit.jupiter.api.Assertions.*;

class ConfirmCodeRepositoryTest {

    private final ConfirmCodeRepository repository = new ConfirmCodeRepository();
    private final String idOperation = "1";
    private final String codeValue = "0000";
    private final String wrongCodeValue = "6666";


    @Test
    void addConfirmation() {
        repository.addConfirmation(idOperation);
        assertTrue(repository.getConfirmCodeMap().size() > 0);
    }

    @Test
    void getIdByCodeValue() {
        repository.addConfirmation(idOperation);
        String actual = "1";
        String expected = repository.getIdByCodeValue(codeValue);
        assertEquals(actual, expected);
    }

    @Test
    void wrongCodeValueGetIdByCode() {
        repository.addConfirmation(idOperation);
        assertThrows(ErrorConfirmation.class, () -> repository.getIdByCodeValue(wrongCodeValue));
    }
}