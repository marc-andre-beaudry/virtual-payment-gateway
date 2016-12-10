package com.marc.vpg.controller;

import com.marc.vpg.controller.ws.TransactionWS;
import com.marc.vpg.service.AccountService;
import com.marc.vpg.service.TransactionService;
import com.marc.vpg.service.domain.AccountBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionControllerImpl {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "", method = { RequestMethod.POST })
    public ResponseEntity<Object> createTransaction(@RequestBody TransactionWS transactionWS) {

        AccountBean withdrawAccountBean = accountService.getAccount(transactionWS.getWithdrawAccountUuid());
        AccountBean depositAccountBean = accountService.getAccount(transactionWS.getDepositAccountUuid());

        transactionService.transfer(withdrawAccountBean, depositAccountBean, transactionWS.getAmount());

        return ResponseEntity.ok().body("");
    }
}
