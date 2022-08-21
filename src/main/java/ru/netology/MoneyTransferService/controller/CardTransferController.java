package ru.netology.MoneyTransferService.controller;
import org.springframework.web.bind.annotation.*;
import ru.netology.MoneyTransferService.service.CardTransferService;
import ru.netology.MoneyTransferService.transaction.PostConfirm;
import ru.netology.MoneyTransferService.transaction.TransferPost;

import javax.validation.Valid;

@RestController
@CrossOrigin
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
