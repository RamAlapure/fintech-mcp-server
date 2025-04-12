package com.github.mcp.fintech.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import com.github.mcp.fintech.record.AccountDetails;
import com.github.mcp.fintech.service.AccountService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Override
    @Tool(name = "getAllAccounts", description = "Get all accounts")
    public List<AccountDetails> getAllAccounts() {
        log.info("Fetching all accounts");
        return List.of(
                new AccountDetails("1", "John Doe", "SAVINGS", new BigDecimal("1000.00"), "USD"),
                new AccountDetails("2", "Jane Smith", "CHECKING", new BigDecimal("2000.00"), "USD"));
    }

    @Override
    @Tool(name = "getAccountDetailsById", description = "Get account details by accountId")
    public AccountDetails getAccountDetailsById(String accountId) {
        log.info("Fetching account details for accountId: {}", accountId);
        if ("1".equals(accountId)) {
            return new AccountDetails("1", "John Doe", "SAVINGS", new BigDecimal("1000.00"), "USD");
        } else if ("2".equals(accountId)) {
            return new AccountDetails("2", "Jane Smith", "CHECKING", new BigDecimal("2000.00"), "USD");
        }
        log.warn("No account found for accountId: {}", accountId);
        return null;
    }
}
