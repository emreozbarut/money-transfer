package com.bsf.money.transfer.service.model.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

import com.bsf.money.transfer.service.model.request.base.Request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MoneyTransferRequest extends Request
{
    @NotBlank
    private Long accountFrom;
    @NotBlank
    private Long accountTo;
    @NotBlank
    private BigDecimal amount;
}
