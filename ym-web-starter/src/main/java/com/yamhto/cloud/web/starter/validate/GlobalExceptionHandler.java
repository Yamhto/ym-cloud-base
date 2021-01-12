package com.yamhto.cloud.web.starter.validate;

import com.yamhto.cloud.web.starter.validate.core.Result;
import com.yamhto.cloud.web.starter.validate.core.ResultBuilder;
import com.yamhto.cloud.web.starter.validate.core.ResultCode;
import com.yamhto.cloud.web.starter.validate.core.WebStarterConstant;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * 类描述： controller层参数处理
 *
 * @ClassName GlobalExceptionHandler
 * @Description controller层参数处理
 * @Author ming.yang
 * @Date 2021/1/12 3:17 下午
 * @Version 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理 POST 请求，返回200{@link HttpStatus.OK}
     *
     * @param ex
     * @return
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder sb = new StringBuilder(ResultCode.PARAM_ERROR.getMsg() + WebStarterConstant.COLONS);
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            sb.append(fieldError.getField()).append(WebStarterConstant.COLONS).
                    append(fieldError.getDefaultMessage()).append(WebStarterConstant.COMMA);
        }
        String msg = sb.toString();
        return ResultBuilder.buildError(ResultCode.PARAM_ERROR.getCode(), msg);
    }

    /**
     * 处理 GET 请求，返回200{@link HttpStatus.OK}
     *
     * @param ex
     * @return
     */
    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result handleConstraintViolationException(ConstraintViolationException ex) {
        return ResultBuilder.buildError(ResultCode.PARAM_ERROR.getCode(), ex.getMessage());
    }
}
