package com.marc.vpg.controller.ws;

import com.marc.vpg.service.domain.AccountBean;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountWS {

    private String uuid;
    private BigDecimal balance;

    public static AccountWS fromAccountBean(AccountBean accountBean) {
        AccountWS ws = new AccountWS();
        ws.setBalance(accountBean.getBalance());
        ws.setUuid(accountBean.getUuid());
        return ws;
    }
}
