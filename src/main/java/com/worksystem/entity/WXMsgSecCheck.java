package com.worksystem.entity;

public class WXMsgSecCheck {
    /**
     * 错误码
     */
    private int errcode;
    /**
     * 错误信息
     */
    private String errMsg;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
