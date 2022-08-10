package com.bsf.money.transfer.service.model.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.bsf.money.transfer.service.constant.ErrorCode;
import com.bsf.money.transfer.service.exception.BalanceNotEnoughException;
import com.bsf.money.transfer.service.model.Account;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AccountDTO
{
    private Long accountId;
    private String name;
    private BigDecimal balance;
    private Date createdAt;
    private Date updatedAt;

    public static AccountDTO convert(Account account)
    {
        return AccountDTO.builder()
                .accountId(account.getId())
                .name(account.getName())
                .balance(account.getBalance())
                .createdAt(account.getCreatedAt())
                .updatedAt(account.getUpdatedAt())
                .build();
    }

    public void validateBalance(BigDecimal amount)
    {
        if (amount.compareTo(this.getBalance()) > 0)
        {
            throw BalanceNotEnoughException.of(String.format("Balance not enough for account_id: %d with amount: %" +
                    ".2f", this.getAccountId(), amount.doubleValue()), ErrorCode.BALANCE_NOT_ENOUGH);
        }
    }
}
