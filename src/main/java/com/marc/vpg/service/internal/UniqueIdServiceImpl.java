package com.marc.vpg.service.internal;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
class UniqueIdServiceImpl implements UniqueIdService {

    @Override
    public String getUuid() {
        return UUID.randomUUID().toString();
    }
}
