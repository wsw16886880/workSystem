package com.worksystem.entity;

import java.util.Date;

public class Note {
    private Integer nid;

    private Integer nsjid;

    private Integer nwid;

    private String ntitle;

    private String nfrom;

    private Integer nweek;

    private String ncontent;

    private Date ndate;

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public Integer getNsjid() {
        return nsjid;
    }

    public void setNsjid(Integer nsjid) {
        this.nsjid = nsjid;
    }

    public Integer getNwid() {
        return nwid;
    }

    public void setNwid(Integer nwid) {
        this.nwid = nwid;
    }

    public String getNtitle() {
        return ntitle;
    }

    public void setNtitle(String ntitle) {
        this.ntitle = ntitle == null ? null : ntitle.trim();
    }

    public String getNfrom() {
        return nfrom;
    }

    public void setNfrom(String nfrom) {
        this.nfrom = nfrom == null ? null : nfrom.trim();
    }

    public Integer getNweek() {
        return nweek;
    }

    public void setNweek(Integer nweek) {
        this.nweek = nweek;
    }

    public String getNcontent() {
        return ncontent;
    }

    public void setNcontent(String ncontent) {
        this.ncontent = ncontent == null ? null : ncontent.trim();
    }

    public Date getNdate() {
        return ndate;
    }

    public void setNdate(Date ndate) {
        this.ndate = ndate;
    }
}