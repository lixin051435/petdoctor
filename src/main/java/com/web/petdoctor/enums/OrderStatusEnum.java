package com.web.petdoctor.enums;

public enum OrderStatusEnum {
    ORDERING(0,"已预约"),
    FINISHED(1,"已完成");

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    OrderStatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
