package com.marc.vpg.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tenants")
public class TenantControllerImpl {

    @RequestMapping(value = "/{tenantUuid}/users", method = { RequestMethod.GET })
    public ResponseEntity<Object> getUserForTenant() {
        return null;
    }
}