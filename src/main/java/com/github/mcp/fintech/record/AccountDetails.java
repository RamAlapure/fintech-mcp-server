package com.github.mcp.fintech.record;

import java.math.BigDecimal;

public record AccountDetails(
        String accountId,
        String accountHolderName,
        String accountType,
        BigDecimal balance,
        String currency
) {
}