package com.xue.order.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@TableName("dwd_eval_one")
public class DwdEvalOne {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;

    @TableField("is_deleted")
    private Integer isDeleted;

    @TableField("beg_date")
    private LocalDate begDate;

    @TableField("secu_accname")
    private String secuAccname;

    @TableField("secu_accid")
    private String secuAccid;

    @TableField("bankamount")
    private BigDecimal bankamount;

    @TableField("bondamount")
    private BigDecimal bondamount;

    @TableField("fundamount")
    private BigDecimal fundamount;

    @TableField("productsamount")
    private BigDecimal productsamount;

    @TableField("receamount")
    private BigDecimal receamount;

    @TableField("repurchase")
    private BigDecimal repurchase;

    @TableField("reverse")
    private BigDecimal reverse;

    @TableField("derivative")
    private BigDecimal derivative;

    @TableField("tbond_futures")
    private BigDecimal tbondFutures;

    @TableField("actulamount")
    private BigDecimal actulamount;

    @TableField("totalassets")
    private BigDecimal totalassets;

    @TableField("liabilities")
    private BigDecimal liabilities;

    @TableField("net_sum")
    private BigDecimal netSum;

    @TableField("price")
    private BigDecimal price;

    @TableField("sumprice")
    private BigDecimal sumprice;

    @TableField("net_grorate")
    private BigDecimal netGrorate;

    @TableField("net_grorate_year")
    private BigDecimal netGrorateYear;

    @TableField("net_grorate_quarter")
    private BigDecimal netGrorateQuarter;

    @TableField("net_grorate_mouth")
    private BigDecimal netGrorateMouth;

    @TableField("net_grorate_week")
    private BigDecimal netGrorateWeek;

    @TableField("net_grorate_day")
    private BigDecimal netGrorateDay;

    @TableField("totalgrand")
    private BigDecimal totalgrand;

    @TableField("bondlb")
    private BigDecimal bondlb;

    @TableField("interest_pay")
    private BigDecimal interestPay;

    @TableField("remark")
    private String remark;

    @TableField("tstk")
    private BigDecimal tstk;

    @TableField("imp_date")
    private LocalDate impDate;

    @TableField("imp_time")
    private LocalDateTime impTime;

    @TableField("data_dt")
    private LocalDate dataDt;

    @TableField("prod_id")
    private Long prodId;

    @TableField("ord_amt")
    private BigDecimal ordAmt;

    @TableField("weighted_principal")
    private BigDecimal weightedPrincipal;

    @TableField("abst_rate")
    private BigDecimal abstRate;

    @TableField("anua_rate")
    private BigDecimal anuaRate;

    @TableField("data_source")
    private String dataSource;

    @TableField("settle_balance")
    private BigDecimal settleBalance;

    @TableField("out_boond")
    private BigDecimal outBoond;

    @TableField("trust_pay")
    private BigDecimal trustPay;

    @TableField("storage_fee")
    private BigDecimal storageFee;

    @TableField("investment_fee")
    private BigDecimal investmentFee;

    @TableField("sales_service_fee")
    private BigDecimal salesServiceFee;

    @TableField("tax_fee")
    private BigDecimal taxFee;

    @TableField("other_pay")
    private BigDecimal otherPay;
}
