package com.xue.order.vo.response;

import com.xue.order.pojo.DwdEvalOne;
import lombok.Data;

import java.util.List;

@Data
public class DwdEvalOneResponse {

    /** 当前页数据列表 */
    private List<DwdEvalOne> records;

    /** 总记录数 */
    private Long total;

    /** 当前页码 */
    private Long pageNum;

    /** 每页条数 */
    private Long pageSize;

    /** 总页数 */
    private Long pages;
}
