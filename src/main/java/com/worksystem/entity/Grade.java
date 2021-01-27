package com.worksystem.entity;

public class Grade {
    private Integer gid;

    private String gname;

    private Integer gtotal;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    public Integer getGtotal() {
        return gtotal;
    }

    public void setGtotal(Integer gtotal) {
        this.gtotal = gtotal;
    }
}