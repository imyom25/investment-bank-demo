package com.investment.bank.factory;

import com.investment.bank.constants.AccountStatus;
import com.investment.bank.constants.CurrencyCode;
import com.investment.bank.entity.Account;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountEntityObjectFactory {

    public static final Integer USER_ID = 1;
    public static final long ACCOUNT_NUMBER = 12121212L;


    private AccountEntityObjectFactory() {
    }


    public static Account getDummyAccountEntityWithUserId(Integer userId) {

        Account account = new Account();
        account.setId(1);
        account.setAccountNumber(ACCOUNT_NUMBER);
        account.setStatus(AccountStatus.ACTIVE);
        account.setUserId(userId);
        account.setAccountNumber(100L);
        account.setCurrencyCode(CurrencyCode.USD);
        return account;


    }


}
