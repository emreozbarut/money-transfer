package com.bsf.money.transfer.service.exception;

import com.bsf.money.transfer.service.constant.ErrorCode;

public class AccountNotFoundException extends BaseException
{
    private static final long serialVersionUID = -3562803315207111825L;

    public AccountNotFoundException(String message, ErrorCode errorCode)
    {
        super(message, errorCode);
    }

    public static AccountNotFoundException of(String message, ErrorCode errorCode)
    {
        return new AccountNotFoundException(message, errorCode);
    }
}
