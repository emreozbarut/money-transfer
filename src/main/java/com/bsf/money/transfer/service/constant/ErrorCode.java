package com.bsf.money.transfer.service.constant;

import lombok.Getter;

@Getter
public enum ErrorCode
{
    ACCOUNT_NOT_FOUND(1L), BALANCE_NOT_ENOUGH(2L), MONEY_TRANSFER_NOT_FOUND(3L);

    private final Long code;

    ErrorCode(Long code)
    {
        this.code = code;
    }
}
