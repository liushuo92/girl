package com.lawrence.enums;

/**
 * Created by liush
 * 2018/8/22   3:28
 */
public enum ResultEnum {
    ERROR(-1,"错误"),
    SUCCESS(1,"成功"),
    PRIMARY_SCHOOL(100,"小学"),
    MIDDLE_SCHOOL(101,"初中"),
    HIGH_SCHOOL(102,"高中")
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
