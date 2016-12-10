package com.marc.vpg.service;

import com.marc.vpg.repository.AccountRepository;
import com.marc.vpg.repository.entity.Account;
import com.marc.vpg.service.domain.AccountBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {

    private final AccountRepository accountRepository;

    @Autowired
    public TransactionServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional
    public void transfer(AccountBean withdrawAccountBean, AccountBean depositAccountBean, BigDecimal amount) {
        checkNotNull(withdrawAccountBean);
        checkNotNull(depositAccountBean);
        checkArgument(!withdrawAccountBean.getUuid().equals(depositAccountBean.getUuid()));
        checkArgument(BigDecimal.ZERO.compareTo(amount) < 0);

        Account withdrawAccount = accountRepository.findByUuid(withdrawAccountBean.getUuid());
        Account depositAccount = accountRepository.findByUuid(depositAccountBean.getUuid());

        withdrawAccount.setBalance(withdrawAccount.getBalance().subtract(amount));
        depositAccount.setBalance(depositAccount.getBalance().add(amount));
    }
}
