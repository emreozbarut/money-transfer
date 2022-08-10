package com.bsf.money.transfer.service.exception;

import com.bsf.money.transfer.service.constant.ErrorCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BaseException extends RuntimeException
{
    private static final long serialVersionUID = -977544459117873373L;
    
    private final String message;
    private final ErrorCode errorCode;
}
