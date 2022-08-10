package com.bsf.money.transfer.service.exception;

import com.bsf.money.transfer.service.constant.ErrorCode;

public class BalanceNotEnoughException extends BaseException
{
    public BalanceNotEnoughException(String message, ErrorCode errorCode)
    {
        super(message, errorCode);
    }
    
    public static BalanceNotEnoughException of(String message, ErrorCode errorCode) {
        return new BalanceNotEnoughException(message, errorCode);
    }
}
