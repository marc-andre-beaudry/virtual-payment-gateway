package com.marc.vpg.controller.ws;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionWS {
    private String withdrawAccountUuid;
    private String depositAccountUuid;
    private BigDecimal amount;
}
