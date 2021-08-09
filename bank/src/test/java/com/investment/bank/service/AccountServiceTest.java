package com.investment.bank.service;


import com.investment.bank.constants.CurrencyCode;
import com.investment.bank.dto.AccountDTO;
import com.investment.bank.entity.Account;
import com.investment.bank.repository.AccountRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static com.investment.bank.factory.AccountEntityObjectFactory.USER_ID;
import static com.investment.bank.factory.AccountEntityObjectFactory.getDummyAccountEntityWithUserId;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService = new AccountService(accountRepository);

    @Captor
    private ArgumentCaptor<Integer> userIdArgumentCaptor;


    @Test
    public void shouldReturnEmptyData_When_NoAccountPresent() {

        //WHEN
        when(accountRepository.findAllByUserId(any(Integer.class))).thenReturn(Lists.newArrayList());
        //THEN
        List<AccountDTO> accountDTOList = accountService.getAccountDetailsByUserId(USER_ID);

        assertThat(accountDTOList).isEmpty();

        //VERIFY
        verify(accountRepository).findAllByUserId(userIdArgumentCaptor.capture());
        Integer userId = userIdArgumentCaptor.getValue();
        assertThat(userId).isEqualTo(USER_ID);

    }

    @Test
    public void shouldReturnAccountData_When_AccountPresent() {

        //GIVEN
        Account dummyAccountDetail = getDummyAccountEntityWithUserId(USER_ID);
        List<Account> accounts = new ArrayList<>();
        accounts.add(dummyAccountDetail);

        //WHEN
        when(accountRepository.findAllByUserId(any(Integer.class))).thenReturn(accounts);
        //THEN
        List<AccountDTO> accountDTOList = accountService.getAccountDetailsByUserId(USER_ID);

        assertThat(accountDTOList).isNotEmpty();
        assertThat(accountDTOList.size()).isEqualTo(1);

        //VERIFY
        verify(accountRepository).findAllByUserId(userIdArgumentCaptor.capture());
        Integer userId = userIdArgumentCaptor.getValue();
        assertThat(userId).isEqualTo(USER_ID);

    }

}
