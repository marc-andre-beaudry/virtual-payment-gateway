package com.marc.vpg.controller.ws;

import lombok.Data;

@Data
public class UserWS {
    private String uuid;
    private String tenantUuid;
    private String email;
}
