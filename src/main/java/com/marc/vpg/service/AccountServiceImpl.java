package com.marc.vpg.service;

import com.marc.vpg.repository.AccountRepository;
import com.marc.vpg.repository.entity.Account;
import com.marc.vpg.service.domain.AccountBean;
import com.marc.vpg.service.internal.UniqueIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UniqueIdService uniqueIdService;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, UniqueIdService uniqueIdService) {
        this.accountRepository = accountRepository;
        this.uniqueIdService = uniqueIdService;
    }

    @Override
    @Transactional
    public AccountBean createAccount() {
        Account account = new Account();
        account.setUuid(uniqueIdService.getUuid());
        account.setBalance(BigDecimal.ZERO);
        Account newAccount = accountRepository.save(account);
        return AccountBean.fromAccount(newAccount);
    }

    @Override
    @Transactional(readOnly = true)
    public AccountBean getAccount(String uuid) {
        return AccountBean.fromAccount(accountRepository.findByUuid(uuid));
    }

    @Override
    @Transactional(readOnly = true)
    public List<AccountBean> getAccounts() {
        return StreamSupport.stream(accountRepository.findAll().spliterator(), false).map(account ->  AccountBean.fromAccount(account)).collect(Collectors.toList());
    }
}
