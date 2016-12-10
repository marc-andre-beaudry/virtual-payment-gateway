package com.marc.vpg.service;

import com.marc.vpg.service.domain.AccountBean;

import java.util.List;

public interface AccountService {
    AccountBean createAccount();
    AccountBean getAccount(String uuid);
    List<AccountBean> getAccounts();
}
