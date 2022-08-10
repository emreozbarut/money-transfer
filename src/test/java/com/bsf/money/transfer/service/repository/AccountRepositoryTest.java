package com.bsf.money.transfer.service.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bsf.money.transfer.service.MoneyTransferServiceApplication;
import com.bsf.money.transfer.service.constant.ErrorCode;
import com.bsf.money.transfer.service.exception.AccountNotFoundException;
import com.bsf.money.transfer.service.model.Account;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MoneyTransferServiceApplication.class)
public class AccountRepositoryTest
{
    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void shouldSaveAccountAndFindById()
    {
        Account account = accountRepository.save(Account.builder().balance(BigDecimal.TEN).name("test").build());
        Account accountFromDB =
                accountRepository.findById(account.getId()).orElseThrow(() -> AccountNotFoundException.of("Account " +
                        "not found", ErrorCode.ACCOUNT_NOT_FOUND));

        assertEquals(account.getId(), accountFromDB.getId());
        assertEquals("test", accountFromDB.getName());
        assertEquals(account.getName(), accountFromDB.getName());
        assertEquals(account.getBalance(), accountFromDB.getBalance());
    }

    @Test
    public void shouldUpdateAccount_whenBalanceChanged()
    {
        Account account = accountRepository.save(Account.builder().balance(BigDecimal.TEN).name("test").build());
        BigDecimal oldBalance = account.getBalance();

        account.setBalance(BigDecimal.ONE);
        accountRepository.save(account);

        Account accountFromDB =
                accountRepository.findById(account.getId()).orElseThrow(() -> AccountNotFoundException.of("Account " +
                        "not found", ErrorCode.ACCOUNT_NOT_FOUND));

        assertNotEquals(oldBalance, accountFromDB.getBalance());
        assertEquals(BigDecimal.ONE.doubleValue(), accountFromDB.getBalance().doubleValue());
    }
}