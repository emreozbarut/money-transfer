package com.bsf.money.transfer.service.exception;

import com.bsf.money.transfer.service.constant.ErrorCode;

public class MoneyTransferNotFoundException extends BaseException
{
    private static final long serialVersionUID = 2997834564200204550L;

    public MoneyTransferNotFoundException(String message, ErrorCode errorCode)
    {
        super(message, errorCode);
    }
    
    public static MoneyTransferNotFoundException of(String message, ErrorCode errorCode) {
        return new MoneyTransferNotFoundException(message, errorCode);
    }
}
