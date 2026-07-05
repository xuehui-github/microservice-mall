package com.xue.order.vo.requests;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OdsIasEvalRequest {

    /** 账户名称（模糊查询） */
    private String secuAccname;

    /** 估值日期-起始（范围查询，含当日） */
    private LocalDate startDate;

    /** 估值日期-结束（范围查询，含当日） */
    private LocalDate endDate;

    /** 当前页码，默认 1 */
    private Long pageNum = 1L;

    /** 每页条数，默认 10 */
    private Long pageSize = 10L;
}
