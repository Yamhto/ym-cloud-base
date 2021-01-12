package com.yamhto.cloud.web.starter.validate.core;

import lombok.Getter;

/**
 * 类描述：
 *
 * @ClassName ResultCode
 * @Description TODO
 * @Author ming.yang
 * @Date 2021/1/12 3:28 下午
 * @Version 1.0
 */
@Getter
public enum ResultCode {

    SUCCESS("0000", "SUCCESS"),

    PARAM_ERROR("1000", "PARAM_ERROR"),

    BUSINESS_ERROR("2000", "BUSINESS_ERROR");

    private String code;

    private String msg;

    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
