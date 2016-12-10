package com.marc.vpg.repository;

import com.marc.vpg.repository.entity.Account;
import com.marc.vpg.repository.entity.Tenant;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findByUuid(String uuid);
}
