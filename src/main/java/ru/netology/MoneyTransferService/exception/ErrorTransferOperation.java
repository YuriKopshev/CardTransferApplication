package ru.netology.MoneyTransferService.exception;

public class ErrorTransferOperation extends RuntimeException {
    public ErrorTransferOperation(String message) {
        super(message);
    }
}
