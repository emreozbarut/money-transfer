package com.bsf.money.transfer.service.model.response;

import org.springframework.http.HttpStatus;

import com.bsf.money.transfer.service.model.dto.AccountDTO;
import com.bsf.money.transfer.service.model.response.base.Response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
@ApiModel(value = "CreateAccount Api Model documentation", description = "Response Model")
public class CreateAccountResponse extends Response
{
    @ApiModelProperty(value = "account field")
    private final AccountDTO account;

    public CreateAccountResponse(HttpStatus httpStatus, AccountDTO account)
    {
        super(httpStatus);
        this.account = account;
    }

    public static CreateAccountResponse of(HttpStatus httpStatus, AccountDTO account)
    {
        return new CreateAccountResponse(httpStatus, account);
    }
}
