package ru.netology.MoneyTransferService.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(ErrorConfirmation.class)
    public ResponseEntity<String> ECHandler(ErrorConfirmation e) {
        log.info(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getLocalizedMessage());
    }

    @ExceptionHandler(ErrorInputData.class)
    public ResponseEntity<String> EIDHandler(ErrorInputData e) {
        log.info(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
    }

    @ExceptionHandler(ErrorTransferOperation.class)
    public ResponseEntity<String> EIDHandler(ErrorTransferOperation e) {
        log.info(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
    }
}
