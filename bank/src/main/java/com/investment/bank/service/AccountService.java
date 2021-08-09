package com.investment.bank.service;

import com.investment.bank.dto.AccountDTO;
import com.investment.bank.entity.Account;
import com.investment.bank.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<AccountDTO> getAccountDetailsByUserId(Integer userId) {
        log.info("AccountService.getAccountDetailsByUserId:- getting account details for user {}",userId);
        List<Account> accountList = accountRepository.findAllByUserId(userId);

//        Optional<Account> first = accountList.stream().findFirst();
//        first.get().setAccountNumber(123L);


//
        log.info("AccountService.getAccountDetailsByUserId:- account details for user is {}",accountList.size());

        return accountList.stream().map(this::buildAccountDTO).collect(Collectors.toList());
    }

    private AccountDTO buildAccountDTO(Account entity) {

        return new ModelMapper().map(entity, AccountDTO.class);
    }
}
