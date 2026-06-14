package com.xue.order.vo.requests;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OdsAppGsmRequest {

    /** 账户名称（模糊查询） */
    private String acctName;

    /** 数据日期（精确匹配） */
    private LocalDate etlTxDate;

    /** 当前页码，默认 1 */
    private Long pageNum = 1L;

    /** 每页条数，默认 10 */
    private Long pageSize = 10L;
}
