package com.worksystem.entity;

import java.util.List;
import java.util.Map;

/**
 * @author wsw16
 */
public class PageSet {
    /**
     * 总记录数
     */
    private Integer total;
    /**
     * 开始位置
     */
    private Integer start;
    /**
     * 总页码
     */
    private Integer pageCount;
    /**
     * 当前页最大条数
     */
    private Integer pageSize;
    /**
     * 当前页数据
     */
    List<Map<String, Object>> pageResult;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<Map<String, Object>> getPageResult() {
        return pageResult;
    }

    public void setPageResult(List<Map<String, Object>> pageResult) {
        this.pageResult = pageResult;
    }
}
