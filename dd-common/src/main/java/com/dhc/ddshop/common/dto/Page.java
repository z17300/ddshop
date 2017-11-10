package com.dhc.ddshop.common.dto;

public class Page {
    private int page;//当前页码
    private int rows;//显示条数
    //private int offset;//偏移量

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getOffset() {
        return (page-1)*rows;//得到当前页面的偏移量并且不需要手工设置
    }


}
