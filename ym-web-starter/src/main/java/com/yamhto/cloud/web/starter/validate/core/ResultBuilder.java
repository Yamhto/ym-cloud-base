package com.yamhto.cloud.web.starter.validate.core;

/**
 * 类描述：
 *
 * @ClassName ResultBuilder
 * @Description 构建返回前端的结果数据
 * @Author ming.yang
 * @Date 2021/1/12 3:34 下午
 * @Version 1.0
 */
public class ResultBuilder {

    public static <T> Result<T> buildSuccess(String code, String msg) {
        return new Result<>(code, msg, null);
    }

    public static <T> Result<T> buildSuccess(String code, String msg, T data) {
        return new Result<>(code, msg, data);
    }

    public static <T> Result<T> buildSuccess(Result<T> result) {
        return new Result<>(result.getCode(), result.getMsg(), result.getData());
    }

    public static <T> Result<T> buildError(String code, String msg) {
        return new Result<>(code, msg, null);
    }

    public static <T> Result<T> buildError(String code, String msg, T data) {
        return new Result<>(code, msg, data);
    }

    public static <T> Result<T> buildError(Result<T> result) {
        return new Result<>(result.getCode(), result.getMsg(), result.getData());
    }


}
