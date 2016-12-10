package com.marc.vpg.repository;

import com.marc.vpg.repository.entity.Tenant;
import org.springframework.data.repository.CrudRepository;

public interface TenantRepository extends CrudRepository<Tenant, Long> {
    Tenant findByUuid(String uuid);
}
