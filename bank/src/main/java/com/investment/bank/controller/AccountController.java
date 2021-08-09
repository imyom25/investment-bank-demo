package com.investment.bank.controller;

import com.investment.bank.dto.AccountDTO;
import com.investment.bank.dto.AccountDetailResponse;
import com.investment.bank.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @GetMapping("/v1/accounts/{userId}/details")
    @ResponseBody
    public List<AccountDetailResponse> getAccountDetails(@PathVariable Integer userId){
        log.info("AccountController.getAccountDetails:- fetching details for user {}",userId);
        List<AccountDTO> accountDetails = accountService.getAccountDetailsByUserId(userId);
        log.info("AccountController.getAccountDetails:- fetched details for user {}",userId);

        return accountDetails.stream().map(this::buildAccountDetailResponse).collect(Collectors.toList());
    }

    private AccountDetailResponse buildAccountDetailResponse(AccountDTO accountDTO) {
        AccountDetailResponse response = new AccountDetailResponse();
        response.setAccountNumber(accountDTO.getAccountNumber());
        response.setBalance(accountDTO.getBalance());
        return response;
    }

}
