package com.worksystem.entity;

public class SchoolTimetable {
    private Integer stid;

    private Integer stgid;

    private Integer stsemester;

    private String stfile;

    public Integer getStid() {
        return stid;
    }

    public void setStid(Integer stid) {
        this.stid = stid;
    }

    public Integer getStgid() {
        return stgid;
    }

    public void setStgid(Integer stgid) {
        this.stgid = stgid;
    }

    public Integer getStsemester() {
        return stsemester;
    }

    public void setStsemester(Integer stsemester) {
        this.stsemester = stsemester;
    }

    public String getStfile() {
        return stfile;
    }

    public void setStfile(String stfile) {
        this.stfile = stfile == null ? null : stfile.trim();
    }
}