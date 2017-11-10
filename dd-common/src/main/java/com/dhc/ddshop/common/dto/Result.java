package com.dhc.ddshop.common.dto;

import java.util.List;

//封装分页响应类
public class Result<T> {
    private int total;
    private List<T> rows;//指定页码显示的记录集合

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
