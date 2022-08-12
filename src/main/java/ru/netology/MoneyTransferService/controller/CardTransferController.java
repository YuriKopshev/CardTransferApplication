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
    public ResponseEntity<?> transfer(@RequestBody TransferPost transferPost) {
        String id =  service.transfer(transferPost);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping("/confirmOperation")
    public ResponseEntity<?> confirmOperation(@RequestBody PostConfirm confirm) {
        String id =  service.confirmOperation(confirm);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
