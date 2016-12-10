package com.marc.vpg.service.domain;

import com.marc.vpg.repository.entity.Account;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AccountBean {

    private BigDecimal balance;
    private String uuid;

    public static AccountBean fromAccount(Account account) {
        AccountBean bean = new AccountBean();
        bean.setBalance(account.getBalance());
        bean.setUuid(account.getUuid());
        return bean;
    }
}
