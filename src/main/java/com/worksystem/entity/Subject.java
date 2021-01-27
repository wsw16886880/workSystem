package com.worksystem.entity;

public class Subject {
    private Integer sjid;

    private String sjname;

    private String sjtname;

    private Integer sjtid;

    private Integer sjgid;

    private Integer sjsemester;

    public Integer getSjid() {
        return sjid;
    }

    public void setSjid(Integer sjid) {
        this.sjid = sjid;
    }

    public String getSjname() {
        return sjname;
    }

    public void setSjname(String sjname) {
        this.sjname = sjname == null ? null : sjname.trim();
    }

    public String getSjtname() {
        return sjtname;
    }

    public void setSjtname(String sjtname) {
        this.sjtname = sjtname == null ? null : sjtname.trim();
    }

    public Integer getSjtid() {
        return sjtid;
    }

    public void setSjtid(Integer sjtid) {
        this.sjtid = sjtid;
    }

    public Integer getSjgid() {
        return sjgid;
    }

    public void setSjgid(Integer sjgid) {
        this.sjgid = sjgid;
    }

    public Integer getSjsemester() {
        return sjsemester;
    }

    public void setSjsemester(Integer sjsemester) {
        this.sjsemester = sjsemester;
    }
}