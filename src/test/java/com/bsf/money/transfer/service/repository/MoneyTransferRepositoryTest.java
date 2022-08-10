package com.bsf.money.transfer.service.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.bsf.money.transfer.service.MoneyTransferServiceApplication;
import com.bsf.money.transfer.service.constant.ErrorCode;
import com.bsf.money.transfer.service.exception.AccountNotFoundException;
import com.bsf.money.transfer.service.model.Account;
import com.bsf.money.transfer.service.model.MoneyTransfer;
import com.bsf.money.transfer.service.model.request.MoneyTransferRequest;
import com.bsf.money.transfer.service.model.response.RetrieveTransferResponse;
import com.bsf.money.transfer.service.service.MoneyTransferService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MoneyTransferServiceApplication.class)
public class MoneyTransferRepositoryTest
{
    @Autowired
    private MoneyTransferRepository transferRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private MoneyTransferService moneyTransferService;

    @Test
    public void shouldSaveTransfer()
    {
        Account to = accountRepository.save(Account.builder().name("to").balance(BigDecimal.TEN).build());
        Account from = accountRepository.save(Account.builder().name("from").balance(BigDecimal.TEN).build());

        moneyTransferService.transferMoney(MoneyTransferRequest.builder().accountFrom(from.getId()).accountTo(to.getId()).amount(BigDecimal.ONE).build());

        Account accountToOnDB = accountRepository.findById(to.getId()).orElseThrow(() -> AccountNotFoundException.of(
                "Account not found", ErrorCode.ACCOUNT_NOT_FOUND));
        Account accountFromOnDB =
                accountRepository.findById(from.getId()).orElseThrow(() -> AccountNotFoundException.of("Account not " +
                        "found", ErrorCode.ACCOUNT_NOT_FOUND));

        assertEquals(to.getBalance().add(BigDecimal.ONE).doubleValue(), accountToOnDB.getBalance().doubleValue());
        assertEquals(from.getBalance().subtract(BigDecimal.ONE).doubleValue(),
                accountFromOnDB.getBalance().doubleValue());
    }

    @Test
    public void shouldRetrieveTransfer()
    {
        Account to = accountRepository.save(Account.builder().name("to").balance(BigDecimal.TEN).build());
        Account from = accountRepository.save(Account.builder().name("from").balance(BigDecimal.TEN).build());

        MoneyTransfer moneyTransfer =
                transferRepository.save(MoneyTransfer.builder().to(to).from(from).amount(BigDecimal.ONE).build());

        RetrieveTransferResponse response = moneyTransferService.retrieveTransfer(moneyTransfer.getId());

        assertEquals(HttpStatus.FOUND, response.getStatus());
        assertEquals(moneyTransfer.getId(), response.getMoneyTransfer().getId());
    }
}