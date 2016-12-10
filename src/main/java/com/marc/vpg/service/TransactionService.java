package com.marc.vpg.service;

import com.marc.vpg.service.domain.AccountBean;

import java.math.BigDecimal;

public interface TransactionService {

    void transfer(AccountBean withdrawAccountBean, AccountBean depositAccountBean, BigDecimal amount);
}
