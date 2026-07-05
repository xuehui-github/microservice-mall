package com.xue.order.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class OdsAppGsmTgValuAssetLiabDQ {

    private Long id;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer isDeleted;
    private String outKey;
    private String bizDt;
    private String batchCode;
    private String acctId;
    private String acctName;
    private BigDecimal ordAmt;
    private BigDecimal totalAsset;
    private BigDecimal netAsset;
    private BigDecimal cashBal;
    private BigDecimal weightedPrincipal;
    private BigDecimal unitNetVal;
    private BigDecimal abstRate;
    private BigDecimal anuaRate;
    private LocalDate etlTxDate;
}
