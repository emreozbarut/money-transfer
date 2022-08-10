package com.bsf.money.transfer.service.model.response.base;

import org.springframework.http.HttpStatus;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Response
{
    @ApiModelProperty(value = "Http Status")
    private HttpStatus status;
}
