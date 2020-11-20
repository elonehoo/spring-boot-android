package com.inet.code.utlis;

import java.util.List;

/**
 * 分页实体类
 *
 * @author HCY
 * @since 2020/11/20 8:47 上午
 */
public  class PageUtils<T> {
    /**
     * 总共多少条
     */
    private Integer  total;
    /**
     * 条目数
     */
    private Integer  entries;
    /**
     * 内容
     */
    private List<T> records;
    /**
     * 有多少页
     */
    private Integer pages;


    public PageUtils() {
    }

    public PageUtils(Integer total, Integer entries, List<T> records, Integer pages) {
        this.total = total;
        this.entries = entries;
        this.records = records;
        this.pages = pages;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getEntries() {
        return entries;
    }

    public void setEntries(Integer entries) {
        this.entries = entries;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
}
