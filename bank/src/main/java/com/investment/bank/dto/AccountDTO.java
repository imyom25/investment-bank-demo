package com.investment.bank.dto;

import com.investment.bank.constants.CurrencyCode;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;

@Data
public class AccountDTO {

    @Id
    private Integer id;
    private Long accountNumber;
    private String status;
    private BigDecimal balance;
    private Integer userId;
    private CurrencyCode currencyCode;

}
