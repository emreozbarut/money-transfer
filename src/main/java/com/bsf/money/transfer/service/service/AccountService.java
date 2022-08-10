package com.bsf.money.transfer.service.service;

import com.bsf.money.transfer.service.model.Account;
import com.bsf.money.transfer.service.model.request.CreateAccountRequest;
import com.bsf.money.transfer.service.model.response.CreateAccountResponse;
import com.bsf.money.transfer.service.model.response.RetrieveAccountResponse;

public interface AccountService
{
    Account getById(Long id);

    CreateAccountResponse createAccount(CreateAccountRequest request);

    Account save(Account account);

    RetrieveAccountResponse retrieveBy(Long accountId);
}
