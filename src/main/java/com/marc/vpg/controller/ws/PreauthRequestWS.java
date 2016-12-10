package com.marc.vpg.controller.ws;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PreauthRequestWS {

    private String accountUuid;
    private BigDecimal amount;
}
