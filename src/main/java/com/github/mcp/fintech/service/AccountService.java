package com.github.mcp.fintech.service;

import com.github.mcp.fintech.record.AccountDetails;

import java.util.List;

public interface AccountService {

    List<AccountDetails> getAllAccounts();

    AccountDetails getAccountDetailsById(String accountId);

}
