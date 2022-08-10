package com.bsf.money.transfer.service.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.bsf.money.transfer.service.exception.AccountNotFoundException;
import com.bsf.money.transfer.service.model.Account;
import com.bsf.money.transfer.service.repository.AccountRepository;
import com.bsf.money.transfer.service.service.impl.AccountServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceImplTest
{
    @InjectMocks
    private AccountServiceImpl accountService;

    @Mock
    private AccountRepository accountRepository;

    @Test
    public void shouldReturnAccount_whenAccountFound()
    {
        Long accountId = 1L;
        Account account = Account.builder().id(accountId).build();
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(account));

        assertEquals(account, accountService.getById(accountId));
    }

    @Test
    public void shouldThrowException_whenAccountNotFound()
    {
        Long accountId = 1L;
        when(accountRepository.findById(accountId)).thenReturn(Optional.empty());
        try
        {
            accountService.getById(accountId);
        }
        catch (RuntimeException re)
        {
            assertEquals(AccountNotFoundException.class.getName(), re.getClass().getName());
        }
    }
}