package com.github.mcp.fintech.controller;

import com.github.mcp.fintech.record.AccountDetails;
import com.github.mcp.fintech.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<AccountDetails> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{accountId}")
    public AccountDetails getAccountDetailsById(@PathVariable String accountId) {
        return accountService.getAccountDetailsById(accountId);
    }

    @GetMapping("/{accountId}/balance")
    public String getAccountBalance(@PathVariable String accountId) {
        AccountDetails accountDetails = accountService.getAccountDetailsById(accountId);
        if (accountDetails != null) {
            return "Account balance for accountId " + accountId + " is " + accountDetails.balance();
        } else {
            return "Account not found";
        }
    }

}
