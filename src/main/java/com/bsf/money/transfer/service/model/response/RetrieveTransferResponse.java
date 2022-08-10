package com.bsf.money.transfer.service.model.response;

import org.springframework.http.HttpStatus;

import com.bsf.money.transfer.service.model.dto.MoneyTransferDTO;
import com.bsf.money.transfer.service.model.response.base.Response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
@ApiModel(value = "RetrieveTransfer Api Model documentation", description = "Response Model")
public class RetrieveTransferResponse extends Response
{
    @ApiModelProperty(value = "moneyTransfer field")
    private final MoneyTransferDTO moneyTransfer;
    
    public RetrieveTransferResponse(HttpStatus httpStatus, MoneyTransferDTO moneyTransfer) {
        super(httpStatus);
        this.moneyTransfer = moneyTransfer;
    }
    
    public static RetrieveTransferResponse of(HttpStatus httpStatus, MoneyTransferDTO moneyTransfer) {
        return new RetrieveTransferResponse(httpStatus, moneyTransfer);
    }
}
