package com.worksystem.entity;

import java.util.Date;

public class Notice {
    private Integer nid;

    private String ntitle;

    private String nfrom;

    private Date ndate;

    private Integer naid;

    private Integer ngid;

    private Integer ntype;

    private Integer nemergency;

    private String ncontent;

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
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

    public Date getNdate() {
        return ndate;
    }

    public void setNdate(Date ndate) {
        this.ndate = ndate;
    }

    public Integer getNaid() {
        return naid;
    }

    public void setNaid(Integer naid) {
        this.naid = naid;
    }

    public Integer getNgid() {
        return ngid;
    }

    public void setNgid(Integer ngid) {
        this.ngid = ngid;
    }

    public Integer getNtype() {
        return ntype;
    }

    public void setNtype(Integer ntype) {
        this.ntype = ntype;
    }

    public Integer getNemergency() {
        return nemergency;
    }

    public void setNemergency(Integer nemergency) {
        this.nemergency = nemergency;
    }

    public String getNcontent() {
        return ncontent;
    }

    public void setNcontent(String ncontent) {
        this.ncontent = ncontent == null ? null : ncontent.trim();
    }
}