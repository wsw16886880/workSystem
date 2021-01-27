package com.worksystem.entity;

import java.util.Date;

public class Work {
    private Integer wid;

    private Integer wgid;

    private String wname;

    private Integer wsjid;

    private Integer week;

    private String wtype;

    private Integer wtotal;

    private Date wdate;

    private String wfile;

    private String wcontent;

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public Integer getWgid() {
        return wgid;
    }

    public void setWgid(Integer wgid) {
        this.wgid = wgid;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname == null ? null : wname.trim();
    }

    public Integer getWsjid() {
        return wsjid;
    }

    public void setWsjid(Integer wsjid) {
        this.wsjid = wsjid;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public String getWtype() {
        return wtype;
    }

    public void setWtype(String wtype) {
        this.wtype = wtype == null ? null : wtype.trim();
    }

    public Integer getWtotal() {
        return wtotal;
    }

    public void setWtotal(Integer wtotal) {
        this.wtotal = wtotal;
    }

    public Date getWdate() {
        return wdate;
    }

    public void setWdate(Date wdate) {
        this.wdate = wdate;
    }

    public String getWfile() {
        return wfile;
    }

    public void setWfile(String wfile) {
        this.wfile = wfile == null ? null : wfile.trim();
    }

    public String getWcontent() {
        return wcontent;
    }

    public void setWcontent(String wcontent) {
        this.wcontent = wcontent == null ? null : wcontent.trim();
    }
}