package com.investment.bank.entity;

import com.investment.bank.constants.AccountStatus;
import com.investment.bank.constants.CurrencyCode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;

//Add lombok
@Entity
@Setter
@Getter
@EqualsAndHashCode
@Table(name = "Account_Data")
public class Account implements Serializable {

    private static final long serialVersionUID = 26L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column(name = "account_number")
    private Long accountNumber;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    private BigDecimal balance;
    @Column(name = "user_id")
    private Integer userId;
    @Enumerated(EnumType.STRING)
    @Column(name = "currency_code")
    private CurrencyCode currencyCode;

    //TODO. Version for locking check
}
