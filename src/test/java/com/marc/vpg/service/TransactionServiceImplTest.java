package com.marc.vpg.service;

import com.marc.vpg.repository.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.MockitoAnnotations.initMocks;

public class TransactionServiceImplTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private TransactionServiceImpl transactionService;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test(expected = NullPointerException.class)
    public void test_that_null_withdraw_account_is_not_allowed() {
        transactionService.transfer(null, null, null);
    }
}
