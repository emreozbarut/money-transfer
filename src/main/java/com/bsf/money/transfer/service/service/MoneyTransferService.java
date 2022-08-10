package com.bsf.money.transfer.service.service;

import com.bsf.money.transfer.service.model.request.MoneyTransferRequest;
import com.bsf.money.transfer.service.model.response.MoneyTransferResponse;
import com.bsf.money.transfer.service.model.response.RetrieveTransferResponse;

public interface MoneyTransferService
{
    MoneyTransferResponse transferMoney(MoneyTransferRequest request);

    RetrieveTransferResponse retrieveTransfer(Long transferId);
}
