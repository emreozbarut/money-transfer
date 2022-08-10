package com.bsf.money.transfer.service.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bsf.money.transfer.service.constant.ErrorCode;
import com.bsf.money.transfer.service.exception.AccountNotFoundException;
import com.bsf.money.transfer.service.model.Account;
import com.bsf.money.transfer.service.model.dto.AccountDTO;
import com.bsf.money.transfer.service.model.request.CreateAccountRequest;
import com.bsf.money.transfer.service.model.response.CreateAccountResponse;
import com.bsf.money.transfer.service.model.response.RetrieveAccountResponse;
import com.bsf.money.transfer.service.repository.AccountRepository;
import com.bsf.money.transfer.service.service.AccountService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService
{
    private final AccountRepository accountRepository;

    @Override
    public Account getById(Long id)
    {
        log.info(String.format("Account retrieved with id: %d", id));
        return accountRepository.findById(id)
                .orElseThrow(() -> AccountNotFoundException.of(String.format("Account not found with id: %d", id),
                        ErrorCode.ACCOUNT_NOT_FOUND));
    }

    @Override
    public CreateAccountResponse createAccount(CreateAccountRequest request)
    {
        Account account =
                accountRepository.save(Account.builder().name(request.getName()).balance(request.getBalance()).build());
        log.info(String.format("Account created with id: %d", account.getId()));
        return CreateAccountResponse.of(HttpStatus.CREATED, AccountDTO.convert(account));
    }

    @Override
    public Account save(Account account)
    {
        return accountRepository.save(account);
    }

    @Override
    public RetrieveAccountResponse retrieveBy(Long accountId)
    {
        return RetrieveAccountResponse.of(HttpStatus.FOUND, AccountDTO.convert(getById(accountId)));
    }
}
