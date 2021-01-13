package com.yamhto.cloud.web.starter.validate;

import com.yamhto.cloud.web.starter.validate.core.EnumValueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 类描述：
 *
 * @ClassName ValidateEnum
 * @Description ValidateEnum注解
 * @Author ming.yang
 * @Date 2021/1/12 6:56 下午
 * @Version 1.0
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {EnumValueValidator.class})
public @interface ValidateEnum {

    //默认错误消息
    String message() default "必须为指定值";

    String[] strValues() default {};

    int[] intValues() default {};

    //分组
    Class<?>[] groups() default {};

    //负载
    Class<? extends Payload>[] payload() default {};
}
