package ru.netology.MoneyTransferService.service;

import org.springframework.stereotype.Service;
import ru.netology.MoneyTransferService.exception.ErrorConfirmation;
import ru.netology.MoneyTransferService.exception.ErrorTransferOperation;
import ru.netology.MoneyTransferService.model.Card;
import ru.netology.MoneyTransferService.repository.ConfirmCodeRepository;
import ru.netology.MoneyTransferService.repository.TransactionRepository;
import ru.netology.MoneyTransferService.transaction.PostConfirm;
import ru.netology.MoneyTransferService.transaction.TransferPost;
import ru.netology.MoneyTransferService.repository.CardRepository;

import java.util.Objects;


@Service
public class CardTransferService {
    private final CardRepository repository;
    private final TransactionRepository transactionRepository;
    private final ConfirmCodeRepository confirmRepository;

    public CardTransferService(CardRepository repository,
                               TransactionRepository transactionRepository,
                               ConfirmCodeRepository confirmRepository) {
        this.repository = repository;
        this.transactionRepository = transactionRepository;
        this.confirmRepository = confirmRepository;
    }

    public String transfer(TransferPost transferPost) {
        Card cardFrom = repository.getCardByNumber(transferPost.getCardFromNumber());
        Card cardTo = repository.getCardByNumber(transferPost.getCardToNumber());
        long currentAmount = transferPost.getAmountValue();
        if (Objects.equals(cardFrom.getNumber(), cardTo.getNumber())) {
            throw new ErrorTransferOperation("\n" +
                    "Transactions between the same cards is not possible");
        }
        if (cardFrom.getBalance() < currentAmount) {
            throw new ErrorTransferOperation("\n" +
                    "Not enough money on the card");
        } else {
            String idOperation = transactionRepository.addTransaction(transferPost);
            confirmRepository.addConfirmation(idOperation);
            return idOperation;
        }
    }

    private void makeTransferFromCardToCard(Card cardFrom, Card cardTo, Long amount) {
        cardFrom.setBalance(cardFrom.getBalance() - amount);
        cardTo.setBalance(cardTo.getBalance() + amount);
    }

    public String confirmOperation(PostConfirm confirm) {
        String operationId = confirm.getOperationId();
        String code = confirm.getCode();
        String checkCode = confirmRepository.getConfirmationCodeByOperationId(operationId);

        if (checkCode != null && checkCode.equals(code)) {
            TransferPost transaction = transactionRepository.getTransactionById(operationId);
            makeTransferFromCardToCard(repository.getCardByNumber(transaction.getCardFromNumber()
            ), repository.getCardByNumber(transaction.getCardToNumber()), transaction.getAmountValue());
            return confirm.getOperationId();
        } else {
            throw new ErrorConfirmation("Confirmation code is not valid");
        }
    }
}
