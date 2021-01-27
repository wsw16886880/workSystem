package com.worksystem.entity;

import java.util.Date;

public class Message {
    private Integer mid;

    private Integer mgid;

    private Integer mwid;

    private Integer msid;

    private Date mtime;

    private String mcontent;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getMgid() {
        return mgid;
    }

    public void setMgid(Integer mgid) {
        this.mgid = mgid;
    }

    public Integer getMwid() {
        return mwid;
    }

    public void setMwid(Integer mwid) {
        this.mwid = mwid;
    }

    public Integer getMsid() {
        return msid;
    }

    public void setMsid(Integer msid) {
        this.msid = msid;
    }

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    public String getMcontent() {
        return mcontent;
    }

    public void setMcontent(String mcontent) {
        this.mcontent = mcontent == null ? null : mcontent.trim();
    }
}