package com.bsf.money.transfer.service.model.response;

import org.springframework.http.HttpStatus;

import com.bsf.money.transfer.service.model.response.base.Response;

import lombok.Getter;

@Getter
public class MoneyTransferResponse extends Response {
    private final Long transferId;
    
    public MoneyTransferResponse(HttpStatus httpStatus, Long transferId) {
        super(httpStatus);
        this.transferId = transferId;
    }
    
    public static MoneyTransferResponse of(HttpStatus httpStatus, Long transferId) {
        return new MoneyTransferResponse(httpStatus, transferId);
    }
}
