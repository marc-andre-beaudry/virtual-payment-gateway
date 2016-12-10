package com.marc.vpg.repository;

import com.marc.vpg.repository.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUuid(String uuid);
}
