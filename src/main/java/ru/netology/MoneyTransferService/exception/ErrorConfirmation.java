package ru.netology.MoneyTransferService.exception;

public class ErrorConfirmation extends RuntimeException {
    public ErrorConfirmation(String message) {
        super(message);
    }
}
