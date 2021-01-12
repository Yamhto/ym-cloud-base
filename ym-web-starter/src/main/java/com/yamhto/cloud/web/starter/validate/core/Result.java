package com.yamhto.cloud.web.starter.validate.core;

import lombok.Getter;
import lombok.Setter;

/**
 * 类描述：封装返回前端的数据
 *
 * @ClassName Result
 * @Description 封装返回前端的数据
 * @Author ming.yang
 * @Date 2021/1/12 3:23 下午
 * @Version 1.0
 */
@Setter
@Getter
public class Result<T> {

    private String code;

    private String msg;

    private T data;

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
