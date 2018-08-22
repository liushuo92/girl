package com.lawrence.exception;

import com.lawrence.enums.ResultEnum;

/**
 * Created by liush
 * 2018/8/22   3:13
 */
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
