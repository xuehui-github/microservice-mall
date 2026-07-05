package com.xue.order.vo.response;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {
    private List<T> records;
    private long total;
    private long pageNum;
    private long pageSize;
    private long pages;

    public static <T> PageResult<T> of(List<T> records, long total, long pageNum, long pageSize) {
        PageResult<T> r = new PageResult<>();
        r.records = records;
        r.total = total;
        r.pageNum = pageNum;
        r.pageSize = pageSize;
        r.pages = (total + pageSize - 1) / pageSize;
        return r;
    }
}
