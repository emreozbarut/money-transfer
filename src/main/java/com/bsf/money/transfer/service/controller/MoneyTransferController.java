package com.bsf.money.transfer.service.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bsf.money.transfer.service.model.request.MoneyTransferRequest;
import com.bsf.money.transfer.service.model.response.MoneyTransferResponse;
import com.bsf.money.transfer.service.model.response.RetrieveTransferResponse;
import com.bsf.money.transfer.service.service.MoneyTransferService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/money/transfer")
public class MoneyTransferController
{

    private final MoneyTransferService moneyTransferService;

    @PostMapping("/")
    public MoneyTransferResponse transferMoney(@Valid @RequestBody MoneyTransferRequest request)
    {
        return moneyTransferService.transferMoney(request);
    }

    @GetMapping("/{transferId}")
    public RetrieveTransferResponse retrieveTransfer(@PathVariable("transferId") Long transferId)
    {
        return moneyTransferService.retrieveTransfer(transferId);
    }
}
