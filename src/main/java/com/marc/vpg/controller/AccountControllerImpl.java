package com.marc.vpg.controller;

import com.marc.vpg.controller.ws.AccountWS;
import com.marc.vpg.service.AccountService;
import com.marc.vpg.service.domain.AccountBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/accounts")
public class AccountControllerImpl {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "", method = { RequestMethod.GET })
    public ResponseEntity<Object> getAccounts() {
        List<AccountBean> accountBeans = accountService.getAccounts();
        return ResponseEntity.ok().body(accountBeans.stream().map(accountBean -> AccountWS.fromAccountBean(accountBean)).collect(Collectors.toList()));
    }

    @RequestMapping(value = "", method = { RequestMethod.POST })
    public ResponseEntity<Object> createAccount() {
        AccountBean createdAccountBean = accountService.createAccount();
        return ResponseEntity.ok().body(AccountWS.fromAccountBean(createdAccountBean));
    }
}
