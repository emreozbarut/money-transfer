package com.bsf.money.transfer.service.model.response;

import org.springframework.http.HttpStatus;

import com.bsf.money.transfer.service.model.dto.AccountDTO;
import com.bsf.money.transfer.service.model.response.base.Response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
@ApiModel(value = "RetrieveAccount Api Model documentation", description = "Response Model")
public class RetrieveAccountResponse extends Response
{
    @ApiModelProperty(value = "account field")
    private final AccountDTO account;

    public RetrieveAccountResponse(HttpStatus httpStatus, AccountDTO account)
    {
        super(httpStatus);
        this.account = account;
    }

    public static RetrieveAccountResponse of(HttpStatus httpStatus, AccountDTO account)
    {
        return new RetrieveAccountResponse(httpStatus, account);
    }
}
