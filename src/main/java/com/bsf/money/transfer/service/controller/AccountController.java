package com.bsf.money.transfer.service.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bsf.money.transfer.service.model.request.CreateAccountRequest;
import com.bsf.money.transfer.service.model.response.CreateAccountResponse;
import com.bsf.money.transfer.service.model.response.RetrieveAccountResponse;
import com.bsf.money.transfer.service.service.AccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
@Api(value = "Account Api documentation")
public class AccountController
{
    private final AccountService accountService;

    @PostMapping("/")
    @ApiOperation(value = "Creates account")
    public CreateAccountResponse createAccount(@Valid @RequestBody CreateAccountRequest request)
    {
        return accountService.createAccount(request);
    }

    @GetMapping("/{accountId}")
    @ApiOperation(value = "Retrieve account")
    public RetrieveAccountResponse getAccount(@PathVariable("accountId") Long accountId)
    {
        return accountService.retrieveBy(accountId);
    }
}
