package com.investment.bank.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class AccountDetailResponse {

    private Long accountNumber;
    private BigDecimal balance;

}
