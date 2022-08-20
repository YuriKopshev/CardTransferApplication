package ru.netology.MoneyTransferService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.netology.MoneyTransferService.service.CardTransferService;
import ru.netology.MoneyTransferService.transaction.PostConfirm;
import ru.netology.MoneyTransferService.transaction.TransferPost;

import javax.validation.Valid;

@RestController()
public class CardTransferController {
    private final CardTransferService service;

    public CardTransferController(CardTransferService service) {
        this.service = service;
    }

    @PostMapping("/transfer")
    public String transfer(@RequestBody TransferPost transferPost) {
        return service.transfer(transferPost);
    }

    @PostMapping("/confirmOperation")
    public String  confirmOperation(@RequestBody PostConfirm confirm) {
        return service.confirmOperation(confirm);
    }
}
