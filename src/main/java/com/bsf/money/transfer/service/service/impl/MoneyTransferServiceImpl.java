package com.bsf.money.transfer.service.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bsf.money.transfer.service.constant.ErrorCode;
import com.bsf.money.transfer.service.exception.MoneyTransferNotFoundException;
import com.bsf.money.transfer.service.model.Account;
import com.bsf.money.transfer.service.model.MoneyTransfer;
import com.bsf.money.transfer.service.model.dto.AccountDTO;
import com.bsf.money.transfer.service.model.dto.MoneyTransferDTO;
import com.bsf.money.transfer.service.model.request.MoneyTransferRequest;
import com.bsf.money.transfer.service.model.response.MoneyTransferResponse;
import com.bsf.money.transfer.service.model.response.RetrieveTransferResponse;
import com.bsf.money.transfer.service.repository.MoneyTransferRepository;
import com.bsf.money.transfer.service.service.AccountService;
import com.bsf.money.transfer.service.service.MoneyTransferService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MoneyTransferServiceImpl implements MoneyTransferService
{
    private final MoneyTransferRepository moneyTransferRepository;
    private final AccountService accountService;
    @Override
    @Transactional
    public MoneyTransferResponse transferMoney(MoneyTransferRequest request)
    {
        Account accountFrom = accountService.getById(request.getAccountFrom());
        AccountDTO.convert(accountFrom).validateBalance(request.getAmount());
        accountFrom.setBalance(accountFrom.getBalance().subtract(request.getAmount()));
        accountService.save(accountFrom);
        
        Account accountTo = accountService.getById(request.getAccountTo());
        MoneyTransfer moneyTransfer = MoneyTransfer.builder()
                .from(accountFrom)
                .to(accountTo)
                .amount(request.getAmount())
                .build();
        MoneyTransfer transfer = moneyTransferRepository.save(moneyTransfer);
        
        accountTo.setBalance(accountTo.getBalance().add(request.getAmount()));
        accountService.save(accountTo);
        
        return MoneyTransferResponse.of(HttpStatus.CREATED, transfer.getId());
    }

    @Override
    public RetrieveTransferResponse retrieveTransfer(Long transferId)
    {
        return RetrieveTransferResponse.of(HttpStatus.FOUND, MoneyTransferDTO.convert(getById(transferId)));
    }
    
    private MoneyTransfer getById(Long transferId) {
        return moneyTransferRepository.findById(transferId).orElseThrow(() -> MoneyTransferNotFoundException.of(String.format("MoneyTransfer not found with id: %d", transferId), ErrorCode.MONEY_TRANSFER_NOT_FOUND));
    }
}
