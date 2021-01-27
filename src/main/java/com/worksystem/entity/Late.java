package com.worksystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Late {
    private Integer lid;

    private Integer ltid;

    private Integer lsid;

    private Integer lgid;

    private String lsname;

    private String lsnumber;

    private String lname;

    private Integer lwid;

    private String issubmit;

    private Integer lweek;

    private Integer lsjid;

    private String lsjname;

    private String ltype;

    private String lfile;

    private Date ldate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date ledate;

    private String lcontent;

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public Integer getLtid() {
        return ltid;
    }

    public void setLtid(Integer ltid) {
        this.ltid = ltid;
    }

    public Integer getLsid() {
        return lsid;
    }

    public void setLsid(Integer lsid) {
        this.lsid = lsid;
    }

    public Integer getLgid() {
        return lgid;
    }

    public void setLgid(Integer lgid) {
        this.lgid = lgid;
    }

    public String getLsname() {
        return lsname;
    }

    public void setLsname(String lsname) {
        this.lsname = lsname == null ? null : lsname.trim();
    }

    public String getLsnumber() {
        return lsnumber;
    }

    public void setLsnumber(String lsnumber) {
        this.lsnumber = lsnumber == null ? null : lsnumber.trim();
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname == null ? null : lname.trim();
    }

    public Integer getLwid() {
        return lwid;
    }

    public void setLwid(Integer lwid) {
        this.lwid = lwid;
    }

    public String getIssubmit() {
        return issubmit;
    }

    public void setIssubmit(String issubmit) {
        this.issubmit = issubmit == null ? null : issubmit.trim();
    }

    public Integer getLweek() {
        return lweek;
    }

    public void setLweek(Integer lweek) {
        this.lweek = lweek;
    }

    public Integer getLsjid() {
        return lsjid;
    }

    public void setLsjid(Integer lsjid) {
        this.lsjid = lsjid;
    }

    public String getLsjname() {
        return lsjname;
    }

    public void setLsjname(String lsjname) {
        this.lsjname = lsjname == null ? null : lsjname.trim();
    }

    public String getLtype() {
        return ltype;
    }

    public void setLtype(String ltype) {
        this.ltype = ltype == null ? null : ltype.trim();
    }

    public String getLfile() {
        return lfile;
    }

    public void setLfile(String lfile) {
        this.lfile = lfile == null ? null : lfile.trim();
    }

    public Date getLdate() {
        return ldate;
    }

    public void setLdate(Date ldate) {
        this.ldate = ldate;
    }

    public Date getLedate() {
        return ledate;
    }

    public void setLedate(Date ledate) {
        this.ledate = ledate;
    }

    public String getLcontent() {
        return lcontent;
    }

    public void setLcontent(String lcontent) {
        this.lcontent = lcontent == null ? null : lcontent.trim();
    }
}