package com.bsf.money.transfer.service.model.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.bsf.money.transfer.service.model.MoneyTransfer;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MoneyTransferDTO
{
    private Long id;
    private BigDecimal amount;
    private Long accountFromId;
    private Long accountToId;
    private Date createdAt;
    private Date updatedAt;
    
    public static MoneyTransferDTO convert(MoneyTransfer moneyTransfer) {
        return MoneyTransferDTO.builder()
                .id(moneyTransfer.getId())
                .amount(moneyTransfer.getAmount())
                .accountFromId(moneyTransfer.getFrom().getId())
                .accountToId(moneyTransfer.getTo().getId())
                .createdAt(moneyTransfer.getCreatedAt())
                .updatedAt(moneyTransfer.getUpdatedAt())
                .build();
    }
}
