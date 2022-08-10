package com.bsf.money.transfer.service.model.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

import com.bsf.money.transfer.service.model.request.base.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountRequest extends Request
{
    @NotBlank
    private String name;
    private BigDecimal balance;
}
