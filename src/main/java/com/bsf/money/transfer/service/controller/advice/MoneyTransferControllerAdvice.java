package com.bsf.money.transfer.service.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bsf.money.transfer.service.exception.AccountNotFoundException;
import com.bsf.money.transfer.service.exception.BalanceNotEnoughException;
import com.bsf.money.transfer.service.exception.MoneyTransferNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class MoneyTransferControllerAdvice {

    private static final String LOG_MESSAGE = "MoneyTransferControllerAdvice handles %s";
    
    @ExceptionHandler(AccountNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String accountNotFoundHandler(AccountNotFoundException exception) {
        log.info(String.format(LOG_MESSAGE, exception.getClass().getName()));
        return exception.getMessage();
    }
    
    @ExceptionHandler(BalanceNotEnoughException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String balanceNotEnoughHandler(BalanceNotEnoughException exception) {
        log.info(String.format(LOG_MESSAGE, exception.getClass().getName()));
        return exception.getMessage();
    }

    @ExceptionHandler(MoneyTransferNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String balanceNotEnoughHandler(MoneyTransferNotFoundException exception) {
        log.info(String.format(LOG_MESSAGE, exception.getClass().getName()));
        return exception.getMessage();
    }
}
